```java
@Override //오버라이드 검증 : 컴파일 타임
public boolean equals(Object o){
//Object o에 null이 오거나 Car의 인스턴스가 오지 않는 경우 바로 결과값이 false
if(o==null || !(o instanceof Car)){
		return false;
}
//헤더에서 c2 = Object o로 형변환 되었기 때문에
//가격을 사용하기 위해 형변환이 필요 : Object -> car
Car temp = (Car)o;
boolean result1 = model.equals(temp.getModel()); //모델비교
boolean result2 = color.equals(temp.getColor()); //색상비교
return result1 && result2;
}

@Override
public String toString(){
	return str;
}
```
