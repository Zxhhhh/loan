package com.gy612.loan.utils;

import java.util.Collection;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 服务端消息推送类
 * 原理:获取到服务器上当前在线的所有的session会话，然后组装一下js代码，最后发送给所有的这些用户。
 * @author K550J
 *
 */
public class DwrPush {
	
	/**
	 * 确定页面身份
	 * @param role
	 * @param name
	 */
    public static void OnPage(String role,String name) {
        ScriptSession session = WebContextFactory.get().getScriptSession();
        session.setAttribute("role", role);
        session.setAttribute("name", name);
    }
	
	/**
	 * 发送反馈推送方法
	 * @param msg
	 */
	public static void FeedbackSend(String targetRole,String msg){
		
		System.out.println("进入方法");
//		//获得客户端的上下文对象
//		WebContext webContext = WebContextFactory.get();
//		
//		//ScriptSession:每个请求都会生成的一个会话
//		//getAllScriptSessions:获得全部scriptSession
//		Collection<ScriptSession> sessions  = webContext.getAllScriptSessions();
//		System.out.println("size:"+sessions.size());
//
//		//构建发送所需的JS脚本
//		ScriptBuffer scriptBuffer = new ScriptBuffer();
//		//调用客户端的js脚本
//		scriptBuffer.appendScript("callback(");
//		scriptBuffer.appendData(msg);
//		scriptBuffer.appendScript(")");
//		
//		Util util = new Util(sessions);
//		util.addScript(scriptBuffer);
		
		final String sendRole = targetRole;
		final String autoMessageString = msg;
		
		ScriptSession session = WebContextFactory.get().getScriptSession();
		
		final String myName = session.getAttribute("name").toString();
		
		//from:获得自己的标识
		final String from = session.getAttribute("name").toString();
		System.out.println("From:"+from+",To:"+sendRole+",Msg:"+msg);
		
		//通过ScriptSessionFilter筛选符合条件的ScriptSession
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			
			// 实现match方法，条件为真为筛选出来的session
			@Override
			public boolean match(ScriptSession session) {
				
				boolean flag = false;
				String role = session.getAttribute("role").toString();
				
				if(role!=null&&role.equals(sendRole)){
					flag = true;
				}
				
				return flag;
			}
		}, new Runnable() {
			
			private ScriptBuffer script = new ScriptBuffer();
			
			//设定前台接收消息的方法和参数
			@Override
			public void run() {
				script.appendCall("callback","用户"+myName+"发来反馈:"+autoMessageString);
				Collection<ScriptSession> sessions = Browser.getTargetSessions();
				
				//向所有符合条件的页面推送消息
				for(ScriptSession scriptSession: sessions){
					if(scriptSession.getAttribute("role").equals(sendRole)){
						scriptSession.addScript(script);
					}
				}
			}
		});
	}
	
	/**
	 * 消息推送方法
	 * @param targetUser
	 * @param msg
	 */
	public static void ServerSend(String targetUser,String msg){
		
		System.out.println("进入ServerSend");
		
		final String sendUser = targetUser;
		final String autoMessageString = msg;
		
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			
			@Override
			public boolean match(ScriptSession session) {
				
				boolean flag = false;
				String name = session.getAttribute("name").toString();
				if(name!=null&&name.equals(sendUser)){
					flag = true;
				}
				return flag;
			}
		}, new Runnable() {
			
			private ScriptBuffer script = new ScriptBuffer();
			
			@Override
			public void run() {
				script.appendCall("serverCall","系统推送:"+autoMessageString);
				Collection<ScriptSession> sessions = Browser.getTargetSessions();
				for(ScriptSession scriptSession:sessions){
					if(scriptSession.getAttribute("name").equals(sendUser)){
						scriptSession.addScript(script);
					}
				}
			}
		});
	}
	

	
}
