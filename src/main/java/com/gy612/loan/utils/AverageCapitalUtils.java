package com.gy612.loan.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gy612.loan.dto.LoanPerMonthReturnDetail;
import com.gy612.loan.dto.LoanReturnDetail;

/**
 * 等额本金是指一种贷款的还款方式，是在还款期内把贷款数总额等分，每月偿还同等数额的本金和剩余贷款在该月所产生的利息，这样由于每月的还款本金额固定，
 * 而利息越来越少，借款人起初还款压力较大，但是随时间的推移每月还款数也越来越少。
 */
public class AverageCapitalUtils {
	
    /**
     * 等额本金计算获取还款方式为等额本金的【每月偿还本金和利息】
     * <p>
     * 公式：每月偿还本金=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
     *
     * @param invest   总借款额（贷款本金）
     * @param yearRate 年利率
     * @param totalMonth    还款总月数
     * @return 每月偿还本金和利息, 不四舍五入，直接截取小数点最后两位
     */
	
	private static final double YEARRATE = 0.144;//年利率
	
    public static Map<Integer, Double> getPerMonthPrincipalInterest(double invest, double yearRate, int totalMonth) {
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        // 每月本金
        double monthPri = getPerMonthPrincipal(invest, totalMonth);
        // 获取月利率
        double monthRate = yearRate / 12;
        monthRate = new BigDecimal(monthRate).setScale(6, BigDecimal.ROUND_DOWN).doubleValue();
        for (int i = 1; i <= totalMonth; i++) {
            double monthRes = monthPri + (invest - monthPri * (i - 1)) * monthRate;
            monthRes = new BigDecimal(monthRes).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
            map.put(i, monthRes);
        }
        return map;
    }

    /**
     * 等额本金计算获取还款方式为等额本金的每月偿还利息
     * <p>
     * 公式：每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
     *
     * @param invest   总借款额（贷款本金）
     * @param yearRate 年利率
     * @param totalMonth    还款总月数
     * @return 每月偿还利息
     */
    public static Map<Integer, Double> getPerMonthInterest(double invest, double yearRate, int totalMonth) {
        Map<Integer, Double> inMap = new HashMap<Integer, Double>();
        double principal = getPerMonthPrincipal(invest, totalMonth);
        Map<Integer, Double> map = getPerMonthPrincipalInterest(invest, yearRate, totalMonth);
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            BigDecimal principalBigDecimal = new BigDecimal(principal);
            BigDecimal principalInterestBigDecimal = new BigDecimal(entry.getValue());
            BigDecimal interestBigDecimal = principalInterestBigDecimal.subtract(principalBigDecimal);
            interestBigDecimal = interestBigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
            inMap.put(entry.getKey(), interestBigDecimal.doubleValue());
        }
        return inMap;
    }

    /**
     * 等额本金计算获取还款方式为等额本金的【每月偿还本金】
     * <p>
     * 公式：每月应还本金=贷款本金÷还款月数
     *
     * @param invest   总借款额（贷款本金）
     * @param totalMonth    还款总月数
     * @return 每月偿还本金
     */
    public static double getPerMonthPrincipal(double invest, int totalMonth) {
        BigDecimal monthIncome = new BigDecimal(invest).divide(new BigDecimal(totalMonth), 2, BigDecimal.ROUND_DOWN);
        return monthIncome.doubleValue();
    }

    /**
     * 等额本金计算获取还款方式为等额本金的【总利息】
     *
     * @param invest   总借款额（贷款本金）
     * @param yearRate 年利率
     * @param totalMonth    还款总月数
     * @return 总利息
     */
    public static double getInterestCount(double invest, double yearRate, int totalMonth) {
        BigDecimal count = new BigDecimal(0);
        Map<Integer, Double> mapInterest = getPerMonthInterest(invest, yearRate, totalMonth);

        for (Map.Entry<Integer, Double> entry : mapInterest.entrySet()) {
            count = count.add(new BigDecimal(entry.getValue()));
        }
        return count.doubleValue();
    }
    
    public static LoanReturnDetail getReturnDetail(Double loanMoney,Integer loanMonth,Double yearrate){
    	
		  //每月本息
		  Map<Integer, Double> getPerMonthPrincipalInterest = AverageCapitalUtils.getPerMonthPrincipalInterest(loanMoney,yearrate, loanMonth);
		  //每月本金
		  Double principal = AverageCapitalUtils.getPerMonthPrincipal(loanMoney,loanMonth);
		  //每月利息
		  Map<Integer, Double> getPerMonthInterest = AverageCapitalUtils.getPerMonthInterest(loanMoney,yearrate,loanMonth);
		  //总利息
		  Double interestCount = AverageCapitalUtils.getInterestCount(loanMoney,yearrate,loanMonth);
		  //应还款
		  Double returnMoney = interestCount+loanMoney;
		  
		  List<LoanPerMonthReturnDetail> details = new ArrayList<LoanPerMonthReturnDetail>();
		  for(int month=1;month<=loanMonth;month++){
			 Double  principalInterest = getPerMonthPrincipalInterest.get(month);//本月本息
			 Double  interest = getPerMonthInterest.get(month);//本月利息
			 LoanPerMonthReturnDetail detail = new LoanPerMonthReturnDetail(month, principalInterest, principal, interest);
			 details.add(detail);
		  }
		  
		  LoanReturnDetail returnDetail = new LoanReturnDetail(yearrate,loanMoney, interestCount, details);
		  returnDetail.setReturnInvest(returnMoney);
		  
		  
		  return returnDetail;
    	
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        double invest = 1000; // 本金
        int month = 12;
        double yearRate = 0.144; // 年利率
        Map<Integer, Double> getPerMonthPrincipalInterest = getPerMonthPrincipalInterest(invest, yearRate, month);
        System.out.println("等额本金---每月本息：" + getPerMonthPrincipalInterest);
        double benjin = getPerMonthPrincipal(invest, month);
        System.out.println("等额本金---每月本金:" + benjin);
        Map<Integer, Double> mapInterest = getPerMonthInterest(invest, yearRate, month);
        System.out.println("等额本金---每月利息:" + mapInterest);

        double count = getInterestCount(invest, yearRate, month);
        System.out.println("等额本金---总利息：" + count);
    }


}
