package com.gy612.loan.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gy612.loan.dao.CompanyLoanInfoMapper;
import com.gy612.loan.dto.LoanResult;
import com.gy612.loan.entity.CompanyLoanInfo;
import com.gy612.loan.entity.Remind;
import com.gy612.loan.entity.User;
import com.gy612.loan.service.CompanyLoanService;
import com.gy612.loan.service.RemindService;
import com.gy612.loan.service.UserService;
import com.gy612.loan.utils.DwrPush;
import com.gy612.loan.utils.TimeUtils;

/**
 * 企业贷款检查
 * @author K550J
 *
 */
@Component
public class CompanyLoanTask {
	
	
	@Autowired
	private CompanyLoanInfoMapper companyLoanInfoMapper;
	
	@Autowired
	private CompanyLoanService companyLoanService;
	
	@Autowired
	private RemindService remindService;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public void checkLoanStatus(){
		
		System.out.println("个人贷款定时任务");
		
		List<CompanyLoanInfo> loans  = companyLoanService.getCompanyLoanInfoByIsRepay((byte)0);
		
		Long nowTime = new Date().getTime();
		
		//遍历所有个人贷款
		for(CompanyLoanInfo loan:loans){
			//转化为毫秒:1s = 1000ms
			Long deadLineTime = loan.getLoanDeadline().getTime();
			if(nowTime>deadLineTime){//个人贷款超时还款
				System.out.println("超时还款");
				loan.setIsRepay((byte)3); //设置为超时还款
				Integer count = companyLoanInfoMapper.updateByPrimaryKey(loan);
				if(count!=0){
					/*增加一条消息给用户
					 * 1.数据库增加
					 * 2.即时推送一波
					 */
					String deadlineStr = new SimpleDateFormat("yyyy-mm-dd hh:mm").format(loan.getLoanDeadline());
					String content  = "您有一笔截止于:"+deadlineStr+"的企业贷款超时还款，请及时与管理员联系";
					String userId = loan.getUserId();
					Remind remind = new Remind((byte)1,(byte)0,userId,content);//状态未读，消息类型为【贷款反馈】
					LoanResult<Remind> remindResult = remindService.addRemind(remind);
					if(remindResult.isSuccess){
						//TODO 即时推送
						User user = userService.getUserById(userId);
						String name = user.getUsername();
						DwrPush.ServerSend(name,content); //即时推送
					}
				}
			}else if(deadLineTime-nowTime<259200000){//还款截止日期少于3天
				System.out.println("还款提醒");
				/*增加一条提醒给用户
				 * 1.数据库增加
				 * 2.即时推送一波
				 */
				String deadlineStr = new SimpleDateFormat("yyyy-mm-dd hh:mm").format(loan.getLoanDeadline());
				String repayTimeStr = TimeUtils.formatDateTime(deadLineTime-nowTime);
				String content  = "您有一笔截止于:"+deadlineStr+"的个企业款即将到期，距离截至还有: "+repayTimeStr;
				String userId = loan.getUserId();
				Remind remind = new Remind((byte)1,(byte)0,userId,content);//状态未读，消息类型为【贷款反馈】
				LoanResult<Remind> remindResult = remindService.addRemind(remind);
				if(remindResult.isSuccess){
					//TODO 即时推送
					User user = userService.getUserById(userId);
					String name = user.getUsername();
					DwrPush.ServerSend(name,content); //即时推送
				}
			}
		}
	}

}
