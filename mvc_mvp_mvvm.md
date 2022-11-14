# [디자인패턴] MVC, MVP, MVVM 비교
> **각각의 역할을 나눠 코드 관리를 하자**  
# MVC
* MVC패턴은 Model+View+Controller를 합친 용어
> 구조  
* Model : 어플리케이션에서 사용되는 데이터와 그 데이터를 처리하는 부분
* View : 사용자에게 보여지는 UI 부분
* Controller : 사용자의 입력을 받고 처리하는 부분
> 동작  
* MVC에서 View가 업데이트 되는 방법
  * View가 Model을 이용하여 직접 업데이트 하는 방법
  * Model에서 View에서 Notify 하여 업데이트 하는 방법
  * View가 Polling으로 주기적으로 Model의 변경을 감지하여 업데이트 하는 방법
> 특징  
* Controller는 여러개의 View를 선택할 수 있는 1:n 구조
* Controller는 View 를 선택할 뿐 직접 업데이트 하지 않는다
* (view는 Controller를 알지 못합니다.)
> 단점  
* MVC 패턴의 단점은 View와 Model 사이의 의존성이 높다
* View와 Model의 높은 의존성은 어플리케이션이 커질수록 복잡하고 유지보수가 어렵게 만들 수 있습니다.
# MVP
* Model+View+Presenter를 합친 용어
* Controller 대신 Presenter가 존재
* Presenter : View에서 요청한 정보로 Model을 가공하여 View에 전달해 주는 부분
* Presenter는 View와 Model의 인스턴스를 가지고 있어 둘을 연결하는 접착제 역할(Presnter와 View는 1:1관계)
> 장점  
* View와 Model의 의존성이 없다
> 단점  
* 어플리케이션이 복잡해 질 수록 View와 Presenter 사이의 의존성이 강해진다
# MVVM
* Model + View + View Model를 합친 용어
* Model : 어플리케이션에서 사용되는 데이터와 그 데이터를 처리하는 부분
* View : 사용자에서 보여지는 UI부분
* View Model : View를 표현하기 위해 만든 View를 위한 Model입니다. View를 나타내기 위한 Model이자 View를 나타내기 위한 데이터 처리를 하는 부분
* 동작
  1. 사용자의 Action들은 View를 통해 들어오게 됩니다.
  2. View에 Action이 들어오면, **Command 패턴**으로 View Model에 Action을 전달
  3. View Model은 Model에게 데이터를 요청
  4. Model은 View Model에게 요청받은 데이터를 응답
  5. View Model은 응답 받은 데이터를 가공 저장
  6. View View Model과 **Data Binding**하며 화면을 나타남
> 장점  
* View와 Model 사이의 의존성이 없다
# Command Pattern
* 커맨드 패턴은 객체의 행위(메서드)를 클래스로 만들어 캡슐화 하는 패턴
# Data Binding
* 데이터 바인딩을 사용하면 UI에 데이터를 바인딩하는 코드를 xml 파일에 구현
# OCP
* 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계가 되어야 한다.
