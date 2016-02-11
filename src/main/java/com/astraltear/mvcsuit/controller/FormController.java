package com.astraltear.mvcsuit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.astraltear.mvcsuit.domain.FormBean;
import com.astraltear.mvcsuit.util.AjaxUtils;

@Controller
@RequestMapping("/form")
@SessionAttributes("formBean")

/*
http://egloos.zum.com/springmvc/v/535572

@SessionAttributes는 항상 클래스 상단에 위치하며 해당 어노테이션이 붙은 컨트롤러는 @SessionAttributes("세션명")에서 지정하고 있는 
"세션명"을 @RequestMapping으로 설정한 모든 뷰에서 공유하고 있어야 한다는 규칙을 갖고 있다. 
예를 들어 위와 같이 @SessionAttributes("command") 라는 어노테이션이 붙은 클래스라면 
하위의 종속되있는 모든 뷰가 "command"라는 모델 값을 공유하고 있어야 한다는 것이다. 
만약 이 조건을 충족하지 못하면 에러가 발생하게 된다.
   
@ModelAttribute가 붙은 createFormBean()메서드를 볼 수 있는데 이 메서드는 해당 컨트롤러로 접근하려는 모든 요청에 
@ModelAttribute가 붙은 메서드의 리턴 값을 설정된 모델명으로 자동 포함해주는 역할을 담당해준다. 
물론 이미 동일한 이름의 모델이 생성되었있다면 위의 메서드 값은 포함되지 않으며 오로지 설정한 모델명과 일치하는 객체가 존재하지 않는 경우에만 메서드의 리턴 값을 서버의 응답과 함께 클라이언트에게 전송하는 역할을 담당한다.
  
@SessionAttributes는 해당 어노테이션에 설정한 값과 동일한 이름의 모델객체를 발견하면 이를 캐치하여 세션값으로 자동 변경시켜준다. 
그리고 해당 모델객체가 세션값으로 대체되면 앞으로 세션값을 지우기 전까지 해당 이름의 모델명 호출시 세션에 저장된 값을 불러오게 된다.
 */
public class FormController {
	

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@ModelAttribute("formBean")
	public FormBean createFormBean() {
		return new FormBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {}
	
	

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid FormBean formBean, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return null;
		}
		// Typically you would save to a db and clear the "form" attribute from the session 
		// via SessionStatus.setCompleted(). For the demo we leave it in the session.
		String message = "Form submitted successfully.  Bound " + formBean;
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
			return null;
		} else {
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/form";			
		}
	}
}
