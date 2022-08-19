### DBCP(DataBase Connection Pool)
* 사용자가 요청 후 DB 연결이 일어나면 응답 지연이 일어 날 수 있다 (다수의 사용자가 동시에 요청시 과부화)
* DB는 물리적으로 다른 장비에 있으면 연결하고 끊는데 시간이 걸린다
* 미리 일정 갯수의 Connection을 만들어 Pool에 저장을 하고, 사용자의 요청이 발생하면 Connection을 제공하고 사용자와의 연결이 종료된다면 Pool에 다시 반환하여 보관
> initialSize 초기 갯수  
> minldle  최소 보유 갯수  
> maxIdle 최대 유효 갯수  
> maxActive : 최대 (동시)사용  
* 시스템 유휴 프로세스(System Idle Process, 시스템 아이들 프로세스)
* IDLE - 프로세스가 실행하고 있지 않은 상태
* System idle process - 사용하고 있지 않은 CPU
```xml
<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="#{dbcp['dirverClassName']}"></property>
		<property name="url" value="#{dbcp['url']}"/>
		<property name="username" value="#{dbcp['username']}"/>
		<property name="password" value="#{dbcp['password']}"/>
		<property name="maxActive" value="#{dbcp['maxActive']}"/>
		<property name="minIdle" value="#{dbcp['minIdle']}"/>
		<property name="maxIdle" value="#{dbcp['maxIdle']}"/>
		<property name="initialSize" value="#{dbcp['initialSize']}"/>
</bean>
```
### JdbcTemplate 이용
* jdbcTmp.update method
* jdbcTmp.query method
```xml
<bean id="jdbcTmp"  class="org.springframework.jdbc.core.JdbcTemplate">
		<constructor-arg ref="ds"/>
</bean>
```
### propertise 활용하여 코드 변경 줄이기
* propertise 파일을 불러와 쓰면서 코드 변경이 없어진다
* propertise 파일만 변경하면 된다
* spEL 표현 시용
```xml
  <util:properties id="path">
		<prop key="prop">/WEB-INF/spring/properties</prop>
	</util:properties>
	<util:properties id="db" location="#{path['prop']}/db_type.properties"></util:properties>
	<util:properties id="dbcp" location="#{path['prop']}/#{db['name']}_dbcp.properties"></util:properties>
	<util:properties id="sql" location="#{path['prop']}/#{db['name']}_sql.properties"></util:properties>
```
