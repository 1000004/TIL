* **의존성을 낮추기 위해 Cmd와 Dao의 인터페이스를 만들고 이를 관리하는 Facrtry 객체를 만들어 관리함으로써 Servlet과 Cmd는 수정에 따른 영향을 적게 받는다**
* Statement vs PreparedStatement
  * Statement 객체를 생성 이후 sql를 받는다.
  * spl를 가지고 생성하는 PreparedStatement 객체가 성능이 좋다.
  * PreparedStatement는 StudentDAO를 상속 받는다.
* DaoFactory vs DAOProvider
  * 둘 객체는 인터페이스 IDAO를 구현한 DAO 객체들을 관리하기 위해 만들어짐  
  (동일한 인터페이스를 구현하여 동일한 기능을 지원하며 DB에 따른 구현하는 방식이 달라지기 때문에 상황에 맞게 변경이 가능하다) 
  (studentManagement_model_DAO의 경우 StudentDAO, HyperStudentDAO를 두개의 DAO가지고 있으며 각각 Statement를 활용한 예시와 PreparedStatement를 활용한 예시)  
  (실제 DAO의 다형성을 구현하고자하는 목적은 DB가 달라지면 기능 구현하는 방법이 달라지기 때문에 여러 DAO를 관리하기 위함이다)
  * DaoFactory 객체는 web.xml 파일의 servlet의 init-param을 추가하여 제어 (web.xml을 계속 수정해야 한다)
  * DAOProvider 객체는 web.xml 파일의 servlet의 init-param으로 properties 경로를 추가하여 DAO 설정하는 properties 파일로 제어
![image](https://user-images.githubusercontent.com/102463200/183887013-c6b8cf9d-dd67-4c1f-b235-4ae3c9902e58.png)
