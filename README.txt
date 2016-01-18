spring-webmvc 4.2.2.RELEASE

## <beans:import resource="./controllers.xml" />

## <mvc:view-controller path="/" view-name="home"/>

## csrfFilter
	<filter>
		<filter-name>csrfFilter</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
		<async-supported>true</async-supported>
	</filter>
	<filter-mapping>
		<filter-name>csrfFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
	
	<bean id="csrfFilter" class="org.springframework.security.web.csrf.CsrfFilter">
		<constructor-arg>
			<bean
				class="org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository" />
		</constructor-arg>
	</bean>
	<bean id="requestDataValueProcessor"
		class="org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor" />
		
## 샘플페이지 home.jsp 에서 json, xml 타입 처리

## produces, consumes 정리
	Consumes : 수신 하고자하는 데이터 포맷을 정의한다. 
	Produces : 출력하고자 하는 데이터 포맷을 정의한다. 여기서 사용하는 포맷은 "application/json", "text/xml" 이고 각각 json, xml 타입으로 데이터를 출력한다. 
	기타 선택가능한 옵션은 "application/atom+xml", "application/x-www-form-urlencoded", "application/octet-stream", "application/svg+xml", 
	"application/xhtml+xml", "application/xml", "multipart/form-data", "text/html", "text/plain" 등이 있다.
	
	클라이언트는 application/json로 받겠다는 의미를 헤더에 포함해서 서버에 요청한다.
	서버에서는 application/json 형식으로 출력가능한 매핑을 찾는다. 
	
	/producesconsumes/index.jsp
	req.setRequestHeader("Accept", "application/json");
	
	ProducesConsumesController
	@RequestMapping( value="/producesconsumesControl", produces="application/json")
	

## @RequestHeader @RequestParam @CookieValue @RequestBody HttpEntity


## 전통적인 HttpServletRequest HttpServletResponse  Writer OutputStream HttpSession

## ResponseEntity