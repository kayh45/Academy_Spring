<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span {
		font-size : 25px;
	}
</style>
</head>
<body>
  <span>제품명 : ${productVO.name }   </span> <br />
  <span>제품 가격 : ${productVO.price } 원</span> <br /> 
  <span>제품 사이즈 : ${productVO.size }</span> <br />
  <span>제품 수량 : ${productVO.count }</span> <br />
  <!-- !!! 자동으로 가져올때는 항상 클래스명 앞자리가 소문자 !!! -->
</body>
</html>

