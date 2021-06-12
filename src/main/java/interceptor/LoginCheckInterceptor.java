package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import mypkg.config.Member;

public class LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("컨트롤러 실행 전에 동작해요");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loginfo", "홍길동(hong)"); // 바인딩
		return true;
		
//		// 누가 로그인 했으면 true, 미 로그인이면 false를 반환.
//		Member loginfo = (Member)session.getAttribute("loginfo");
//		
//		if(loginfo == null) {
//			return false;
//		} else {
//			return true;
//		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("컨트롤러 실행 후에 동작해요");
		System.out.println(modelAndView.toString());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion 메소드 수행됨");
	}
	
}
