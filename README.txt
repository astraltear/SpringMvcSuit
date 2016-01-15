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