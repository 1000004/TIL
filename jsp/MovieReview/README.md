### Model1과 Model2의 차이점
* JSP로 구성할 수 있는 웹 어플리케이션 아키텍쳐는 크게 model1, model2로 나뉜다
#### model1
* 프로젝트를 JSP(Controller + View)와 Java Bean(Model)으로 구성하여 개발하는 형태
* view 코드와 로직을 처리하는 자바 코드가 함께 있어 jsp 코드 자체가 복접
* 웹 어플리케이션이 만들어질때 초기 모델
* 유지 보수가 어럽다
* 빠른 시간 안에 개발
* 작은 규모 프로젝트에 적합
#### model2
* MVC(Model-View-Controller)패턴
* Fromt Controller가 요청에 대한 흐림제어 담당(서블릿)
* JSP는 view를 맡는다
* Model이 요청에 대한 로직처리를 담당한다.(서비스 클래스 자바빈)
