```java

Document doc = taOutput.getDocument();//입력된 내용 관리
		doc.addDocumentListener(new DocumentListener() {//어댑터 없음 다 오버라이드
			
			@Override
			public void removeUpdate(DocumentEvent e) {//제거
				System.out.println("removeUpdate");
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {//추가
				System.out.println("insertUpdate");
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {//문서 속성 글꼴 변경?
				
			}
		});
    
```
