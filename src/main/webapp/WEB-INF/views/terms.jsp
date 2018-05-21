<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>StockDB | Registration</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/animate.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

서비스 이용 약관 (제 1 장 총 칙)
제 1 조 (목적)
이 약관은 주식회사 이글레오에프티("회사" 또는 “이글레오”)이 제공하는 이글레오  및 이글레오 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
제 2 조 (약관의 효력 및 변경)
1.	① 이 약관은 그 내용을 회사의 웹사이트에 게시하거나 기타의 방법으로 회원에게 공지하고, 이에 동의한 회원이 서비스에 가입함으로써 효력이 발생합니다.
2.	② 회사는 "약관의규제에관한법률", "정보통신망이용촉진및정보보호등에관한법률" 등 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있으며, 약관을 개정할 경우에는 개정약관의 적용일자 7일 이전에 제1항과 같은 방법으로 공지합니다. 단, 회원의 권리 또는 의무에 관한 중요한 내용의 변경은 적용일자 30일 이전에 공지합니다.
3.	③ 제2항의 경우에 회원은 변경된 약관에 동의하지 않으면 언제든지 서비스 이용을 중단하고 이용계약을 해지할 수 있습니다. 회원이 변경된 약관의 효력발생일 이후 계속하여 서비스를 이용하는 경우에는 당해 회원은 약관의 변경사항에 동의한 것으로 간주됩니다.
4.	④ 회원이 개정약관의 적용에 동의하지 않는 경우 회사는 개정 약관의 내용을 적용할 수 없으며, 이 경우 회원은 이용계약을 해지할 수 있습니다. 다만, 기존 약관을 적용할 수 없는 특별한 사정이 있는 경우에는 회사는 이용계약을 해지할 수 있습니다.
제 3 조 (약관 외 준칙)
1.	① "회사"는 "유료서비스" 및 개별 서비스에 대해서는 별도의 이용약관 및 정책(이하 "유료서비스약관 등")을 둘 수 있으며, 해당 내용이 이 약관과 상충할 경우에는 "유료서비스약관 등"이 우선하여 적용됩니다. 
2.	② 이 약관에서 정하지 아니한 사항이나 해석에 대해서는 "유료서비스약관 등" 및 관계법령 또는 상관례에 따릅니다.
제 4 조 (용어의 정의)
이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
1.	① "서비스"라 함은 구현되는 단말기(PC, TV, 휴대형단말기 등의 각종 유무선 장치를 포함)와 상관없이 "회원"이 이용할 수 있는 이글레오 및 이글레오 관련 제반 서비스를 의미합니다.
2.	② "회원"이라 함은 회사의 "서비스"에 접속하여 이 약관에 따라 "회사"와 이용계약을 체결하고 "회사"가 제공하는 "서비스"를 이용하는 고객을 말합니다. 
3.	③ "아이디(ID)"라 함은 "회원"의 식별과 "서비스" 이용을 위하여 "회원"이 정하고 "회사"가 승인하는 문자와 숫자의 조합을 의미합니다. 
4.	④ "비밀번호"라 함은 "회원"이 부여 받은 "아이디와 일치되는 "회원"임을 확인하고 비밀보호를 위해 "회원" 자신이 정한 문자 또는 숫자의 조합을 의미합니다. 
5.	⑤ "유료서비스"라 함은 "회사"가 유료로 제공하는 각종 온라인디지털콘텐츠(각종 정보콘텐츠, VOD, 아이템 기타 유료콘텐츠를 포함) 및 제반 서비스를 의미합니다. 
6.	⑥ “운영자”라 함은 서비스의 전반적인 관리와 원활한 운영을 위하여 회사에서 선정한 사람을 의미합니다. 
7.	⑦ "게시물"이라 함은 "회원"이 "서비스"를 이용함에 있어 "서비스상"에 게시한 부호ㆍ문자ㆍ음성ㆍ음향ㆍ화상ㆍ동영상 등의 정보 형태의 글, 사진, 동영상 및 각종 파일과 링크 등을 의미합니다.
정의한 용어를 제외한 용어의 정의는 거래 관행 및 관련 법령을 따릅니다.
제 2 장 이용계약의 체결
제 5 조 (이용계약의 성립)
이용계약은 서비스를 이용하고자 하는 자의 이용신청에 대한 회사의 이용승낙으로 성립합니다.
제 6 조 (이용신청)
1.	① 서비스를 이용하고자 하는 고객은 약관의 내용에 대하여 동의를 한 다음 회원가입신청을 진행함으로써 이용을 신청합니다.
2.	② 제1항의 약관 동의 시 서비스를 이용하고자 하는 고객이 "위의 이용약관에 동의하십니까?"라는 이용신청시의 물음에 "동의함" 버튼을 누르면 이 약관에 동의하는 것으로 간주됩니다.
3.	③ 온라인 가입신청양식에 기재하는 모든 회원정보는 실제와 일치하는 데이터인 것으로 간주됩니다. 고객이 가입신청양식에 실명이나 실제정보를 입력하지 않은 경우에는 법적인 보호를 받을 수 없으며, 회사는 당해 고객에 대하여 서비스의 이용을 제한할 수 있습니다.
제 7 조 (이용신청의 승낙)
회사는 제6조의 규정에 의해 이용신청 한 고객에 대하여 서비스 이용신청을 승낙합니다.
제 8 조 (이용신청 승낙의 제한 및 보류)
1.	① 회사는 다음 각 호에 해당하는 경우 이용신청에 대하여 승낙을 하지 않거나 사후에 이용계약을 해지할 수 있습니다. 
1.	1. 실명이 아니거나 타인의 명의를 이용한 경우
2.	2. 이용신청시 가입신청양식상의 기재사항을 허위로 하여 신청한 경우
3.	3. 이용신청자가 회사의 채무자로서 채무를 완제하지 않고 있는 경우
4.	4. 이용신청자가 이 약관 제22조 제2항에 의거하여 이용계약이 해지된 사실이 있는 경우로서 회사의 서비스 운영을 저해할 것으로 판단되는 경우
5.	5. 이용신청자가 선량한 풍속 기타 사회질서를 저해하거나 저해할 목적으로 신청한 경우
6.	6. 제17조 제1항을 위반하여 강제 탈퇴된 사용자와 동일한 IP 또는 동일하거나 유사한 아이디를 사용하는 이용신청자로서 회사의 운영을 저해할 것으로 판단되는 경우
2.	② 회사는 14세 미만 아동의 이용신청에 대하여는 승낙을 하지 않습니다.
3.	③ 회사는 다음 각 호에 해당하는 경우에는 그 사유가 해소될 때까지 이용신청에 대한 승낙을 보류할 수 있으며, 그 사유를 웹사이트에 공지합니다. 
1.	1. 설비의 여유가 없는 경우
2.	2. 기술상 또는 업무수행상 지장이 있는 경우
제 9 조 (이용계약 사항의 변경)
1.	① 회원은 이용신청 시 기재한 사항이 변경되었을 경우에는 이를 수정하여야 합니다.
2.	② 회원이 제1항의 수정을 하지 않음으로 인하여 발생되는 문제에 대한 책임은 회원 본인에게 있습니다.
3.	③ 회사는 다음 각 호에 해당하는 경우에는 직권에 의하여 회원의 아이디 사용을 제한하거나 회원의 신청에 의하여 아이디를 변경할 수 있습니다. 
1.	1. 아이디가 미풍양속을 해하는 경우
2.	2. 아이디가 회원의 사생활을 침해할 우려가 있는 경우
3.	3. 기타 합리적인 사유가 있는 경우
제 3 장 서비스의 이용
제 10 조 (서비스의 이용 개시)
회사는 제7조의 규정에 따라 이용신청을 승낙한 때로부터 즉시 서비스를 개시합니다. 다만, 회사의 업무상 또는 기술상의 장애로 인하여 즉시 서비스를 개시하지 못하는 경우에는 회사는 이를 회사의 웹사이트에 공지하거나 회원에게 통지하여야 합니다.
제 11 조 (회원에 대한 통지)
1.	① 회사가 회원에게 통지를 하는 경우, 회원이 회사에 제출한 전화, 전자우편주소 및 홈페이지를 이용하여 통지할 수 있습니다.
2.	② 회사는 필요한 경우 서비스의 내용을 추가 또는 변경할 수 있으며, 추가 또는 변경되는 내용은 회사의 웹사이트에 공지합니다.
3.	③ 회사는 불특정 다수의 회원에 대한 통지의 경우 7일 이상 웹사이트에 게시함으로써 개별 통지에 갈음할 수 있습니다.
제 12 조 (서비스의 이용요금)
1.	① 별도로 표시된 유료서비스를 제외한 모든 서비스는 회원들에게 무료로 제공됩니다.
2.	② 유료서비스의 이용요금 및 결제방식은 해당 서비스에 명시되어 있는 별도의 규정에 따릅니다.
제 13 조 (서비스의 이용시간)
1.	① 서비스의 이용은 연중 무휴, 1일 24시간을 원칙으로 합니다. 다만, 회사는 설비의 정기점검, 보수, 교체 및 고장 등 업무상, 기술상의 이유로 서비스 이용의 전부 또는 일부를 제한할 수 있으며, 이 경우 회사는 사전 또는 사후에 관련 사항을 공지합니다.
2.	② 회사는 제공하는 서비스 중 일부에 대하여 별도의 이용시간을 정할 수 있으며, 이 경우 그 내용을 공지합니다.
제 14 조 (정보의 제공 및 광고의 게재)
1.	① 회사는 서비스를 운용함에 있어서 각종 정보를 회사의 홈페이지에 게재하거나 서면, 전화, SMS, 전자우편을 통하여 회원에게 제공할 수 있습니다.
2.	② 회사는 서비스의 운용과 관련하여 홈페이지, 서비스 화면, 전자우편 등에 광고를 게재할 수 있습니다.
3.	③ 전자우편을 통한 정보 및 광고의 수신을 원치 않는 경우, 회원은 "회원메뉴"의 신청 및 변경을 통해 수신을 거절할 수 있습니다.
4.	④ 회원이 서비스상에 게재되어 있는 광고를 이용하거나 서비스를 통한 광고주의 판촉활동에 참여하는 등의 방법으로 교신 또는 거래를 하는 것은 전적으로 회원과 광고주 간의 문제입니다. 만약 회원과 광고주간에 문제가 발생할 경우 회원과 광고주가 직접 해결하여야 하며, 이와 관련하여 회사는 어떠한 책임도 지지 않습니다.
제 4 장 계약당사자의 권리와 의무
제 15 조 (개인 정보의 보호)
회사는 관련 법령이 정하는 바에 따라 회원 등록정보를 포함한 회원의 개인정보를 보호하기 위해 노력합니다. 회원의 개인정보 보호에 관해서는 관련 법령 및 회사의 "개인정보처리방침"에 정한 바에 의합니다 다만, "회사"의 공식 사이트 이외의 링크된 사이트에서는 "회사"의 개인정보처리방침이 적용되지 않습니다.
제 16 조 (회사의 의무)
1.	① 회사는 이 약관이 정하는 바에 따라 지속적이고 안정적인 서비스를 제공하는 데 최선을 다해야 합니다.
2.	② 회사는 회원의 신용정보를 포함한 개인신상정보의 보안에 대하여 기술적 안전조치를 강구하고 관리에 만전을 기함으로써 회원의 개인정보 보호에 최선을 다해야 합니다.
3.	③ 회사는 회원으로부터 제기되는 의견 및 불만사항이 정당하다고 판단되는 경우 그 사항을 신속히 처리하여야 합니다. 다만, 신속한 처리가 곤란한 경우에는 회원에게 그 사유와 처리일정을 통지하여야 합니다.
4.	④ 회사는 이용계약의 체결, 변경 및 해지 등 회원과의 계약 관련 절차에 있어 회원에게 편의를 제공하도록 노력합니다.
5.	⑤ 회사는 공정하고 건전한 서비스 운영과 지속적인 연구 개발을 통하여 양질의 서비스를 제공함으로써 고객만족을 극대화하여 인터넷 비즈니스 발전에 기여하도록 합니다.
제 17 조 (회원의 의무)
1.	① 회원은 서비스를 이용함에 있어 다음 각 호의 행위를 하여서는 안됩니다. 
1.	1. 신청 또는 변경 시 허위내용을 등록하는 행위
2.	2. 타인의 서비스 아이디 및 비밀번호를 도용하는 행위
3.	3. 타인의 지적재산권을 침해하는 행위
4.	4. 타인의 명예를 훼손하거나 사생활을 침해하는 행위
5.	5. 게시판이나 대화실 등에서 욕설, 비방을 하거나 음란, 폭력적인 내용의 표현을 하는 행위
6.	6. 과실 또는 고의로 허위의 정보를 공개 또는 유포하는 행위
7.	7. 다량의 정보를 전송하거나 동일 또는 유사한 내용의 정보를 반복적으로 게시하여 서비스의 안정적인 운영을 방해하는 행위
8.	8. 광고성 정보를 수신자의 의사에 반하여 전자우편으로 일시에 다량으로 또는 지속적으로 전송하거나 게시판에 게시하여 다른 회원의 서비스 이용을 방해하는 행위
9.	9. 정보통신설비의 오작동이나 정보의 파괴 등을 유발하는 컴퓨터 바이러스 등을 유포하는 행위
10.	10. 서비스를 이용하여 얻은 정보를 회사의 사전 승낙 없이 복제 또는 유통시키거나 상업적으로 이용하는 행위
11.	11. 회사의 정상적인 경영 또는 업무를 방해하거나 서비스의 운영을 방해하는 행위
12.	12. 불법선거운동을 하는 행위
13.	13. 회사의 동의 없이 영리를 목적으로 "서비스"를 사용하는 행위 
14.	14. 기타 미풍양속을 해하거나 관련 법령, 이 약관 또는 회사의 운영규칙에 위반되는 행위
2.	② 회원은 아이디 및 비밀번호의 관리에 상당한 주의를 기울여야 합니다. 이 약관 제16조의 경우를 제외한 아이디와 비밀번호에 관한 관리책임은 회원에게 있으며, 회원은 자신에게 부여된 아이디 및 비밀번호를 제3자가 이용하게 하여서는 안됩니다. 아이디 및 비밀번호의 관리소홀, 부정사용에 의하여 발생하는 결과에 대한 책임은 회사의 고의 또는 과실이 없는 한 회원에게 있습니다. 회원은 자신의 아이디 또는 비밀번호가 부정하게 사용된 경우 반드시 회사에 그 사실을 통보하여야 합니다.
3.	③ 회원은 회사의 사전 서면동의 없이 서비스를 이용하여 영리적인 목적의 영업행위를 하여서는 안됩니다. 이를 위반한 영업행위의 결과에 대하여 회사는 책임을 지지 않으며, 이와 같은 영업행위의 결과로 회사에 손해가 발생한 경우 회원은 회사에 대하여 손해배상의 의무를 집니다.
4.	④ 회원은 명시적 동의가 없는 한 서비스의 이용 권한, 기타 이용계약상의 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공하거나 기타 처분할 수 없습니다.
제 18 조 (게시물 또는 내용물의 삭제 등)
1.	① 회사는 회원이 게시하거나 전달하는 서비스 내의 모든 내용물(회원간 전달 포함)이 다음 각 호의 경우에 해당한다고 판단되는 경우 사전통지 없이 이를 수정, 삭제하거나 그 열람을 제한할 수 있으며, 해당 게시자에게 제재조치를 취할 수 있습니다. 또한 이에 대해 회사는 어떠한 책임도 지지 않습니다. 
1.	1. 회사, 회원 또는 제3자를 비방(인신공격, 모욕, 허위사실유포, 유언비어 등)하거나 명예를 손상시키는 게시물인 경우
2.	2. 미풍양속 또는 공공질서를 위반하는 내용을 유포하는 게시물인 경우
3.	3. 폭력, 비행, 범죄 조장 등 범죄적 행위라고 인정되는 게시물인 경우
4.	4. 회사 또는 타인의 저작권 등 기타 법적 권리를 침해하는 내용이나 자료를 담고 있는 게시물인 경우
5.	5. 특정 지역, 종교, 단체간의 감정대립, 분열을 조장하는 게시물인 경우
6.	6. 회사에서 제공하는 서비스와 관련 없는 내용(음란물, 사행심리를 조장하는 내용, 상품, 사이트 소개, 구인, 대출 등)의 게시물인 경우
7.	7. 타인의 아이디, 필명, 성명 등을 무단으로 도용하거나 타인의 정보를 무단으로 위?변조한 게시물인 경우
8.	8. 불법적인 자료(불법 S/W등)를 소개?유통하는 게시물인 경우
9.	9. 컴퓨터 바이러스를 담고 있는 게시물인 경우
10.	10. 데이터의 손상으로 인하여 내용을 알아볼 수 없는 게시물인 경우
11.	11. 동일 또는 유사한 내용이 반복적으로 게시된 게시물인 경우
12.	12. 내용이 게시판의 성격과 맞지 않거나 건전한 토론문화를 저해하는 것으로 판단되는 게시물인 경우
13.	13. 뚜렷한 근거 없이 반복적으로 투자(매수/매도/투자 등)를 권유하는 게시물인 경우
14.	14. 기타 관련 법령 또는 회사의 지침 등에 위반된다고 판단되는 게시물인 경우
2.	② 회사는 회원이 게시한 게시물에 대해 일정한 게시 또는 저장 기간을 정할 수 있으며, 필요에 따라 이 기간을 변경할 수 있습니다.
3.	③ 회사는 게시물이 많이 게시되는 일부 게시판의 경우 서버의 안정적 운용을 위해 회원이 게시할 수 있는 게시물의 수를 적정한 수준에서 관리할 수 있습니다.
4.	④ 회원은 불가항력적인 장애로 인하여 데이터가 손상되는 경우에 대비하여 보존이 필요한 게시물에 대해서는 개별적으로 저장하여야 하며, 이를 게을리함으로 인하여 발생한 손해에 대하여 회사에 책임을 물을 수 없습니다.
제 19 조 (지적재산권 등)
1.	① 회사가 작성하여 제공하는 서비스에 관한 저작권 및 기타 지적재산권은 회사에 속합니다. 회원은 회사가 제공하는 서비스를 회사의 서면에 의한 사전 동의 없이 복제, 전송, 출판, 배포, 방송 기타 방법에 의하여 이용하거나 제3자에게 이용하게 하여서는 안됩니다.
2.	② 회원이 서비스에 게재한 게시물, 자료 등에 관한 권리와 책임은 이를 게시한 회원에게 있습니다. 회사는 해당 게시물, 자료 등을 게재한 회원의 동의 없이 이를 영리적인 목적으로 사용하지 아니합니다. 다만, 회사는 회원이 게재한 게시물, 자료 등에 대하여 서비스(회사와 업무 제휴 관계에 있는 제 3 자의 인터넷 사이트를 포함) 내에 게재할 수 있는 권리를 가집니다.
3.	③ 회사는 제 17 조의 의무를 위반하는 내용을 담고 있는 게시물에 대하여 수정 또는 삭제할 권한을 갖습니다.
제 5 장 서비스의 이용제한 및 계약의 해지
제 20 조 (서비스 이용제한 등)
1.	① 회사는 회원이 제17조의 의무를 위반한 경우 당해 회원의 서비스 이용을 일부 또는 전부 제한할 수 있습니다.
2.	② 회사가 제1항의 규정에 의하여 회원의 서비스 이용을 제한하는 경우, 제한의 종류 및 기간 등 구체적인 기준은 별도의 회사 규정에 따릅니다.
3.	③ 회사는 회원이 연속하여 1년 이상 로그인하지 않는 경우, 회원정보의 보호를 위해 이용을 제한할 수 있습니다.
제 21 조 (이용제한 및 제한 해지의 절차)
1.	① 회사가 제20조에 따라 서비스 이용제한을 하고자 하는 경우에는 그 사유, 일시 및 기간을 정해 전자우편 또는 전화 등의 방법에 의하여 당해 회원 또는 그 대리인에게 통지하여야 합니다. 다만, 회원이 광고 또는 도배행위를 한 경우 및 위법행위 회원과의 연락이 두절된 경우에는 그러하지 아니합니다.
2.	② 제1항의 규정에 의하여 이용제한의 통지를 받거나 긴급하게 이용제한 조치를 받은 회원 또는 그 대리인은 전자우편 또는 서면의 방법에 의하여 회사에 이의를 제기할 수 있습니다.
3.	③ 회사는 제2항의 규정에 의한 이의신청에 대하여 그 확인을 위한 기간까지 이용제한을 일시 연기할 수 있으며, 확인 결과를 당해 회원 또는 그 대리인에게 통지합니다.
4.	④ 회사는 이용제한기간 중 그 사유가 해소되는 등의 합리적인 사유가 있는 경우에는 이용제한조치를 해제합니다.
제 22 조 (계약의 해지)
1.	① 회원은 이용계약을 해지하고자 하는 경우에는 언제든지 탈퇴신청을 할 수 있습니다. 회사는 회원의 탈퇴신청을 빠른 시간 내에 처리하여야 합니다.
2.	② 회사가 이 약관 제21조에 의하여 회원의 서비스 이용을 제한한 후에도 동일한 행위가 2회 이상 반복되거나 30일 이내에 그 사유가 시정되지 아니하는 경우에는 회사는 당해 회원과의 이용계약을 해지하고 회원탈퇴 처리할 수 있습니다. 회사가 이용계약을 해지하고 회원탈퇴 처리하는 경우, 회사는 사전에 이를 회원에게 미리 통지하고 소명할 기회를 부여합니다.
3.	③ 회사는 제2항에 의하여 탈퇴처리 된 회원이 다시 서비스 이용신청을 하는 경우 그에 대한 승낙을 거절하거나 일정기간 그 승낙을 보류할 수 있습니다.
제 6 장 손해배상 등
제 23 조 (손해배상)
1.	① 회사는 회원의 서비스 이용과 관련하여 회사의 고의 또는 과실에 의해 발생한 회원의 손해를 배상할 책임이 있습니다.
2.	② 회원이 이 약관의 규정을 위반하여 회사 또는 제3자에 손해가 발생한 경우, 동 회원은 회사 및 제3자에 손해를 배상하여야 합니다.
제 24 조 (면책)
1.	① 회사가 천재지변, 전쟁 및 기타 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 대한 책임이 면제됩니다. 
2.	② 회사는 회원의 귀책사유로 인한 서비스 이용의 장애 또는 손해에 대하여 책임을 지지 않습니다. 
3.	③ 회사는 기간통신사업자가 전기통신역무의 제공을 중지하거나 정상적으로 제공하지 아니하여 서비스를 제공하지 못한 경우에는 그에 대한 책임을 부담하지 않습니다.
4.	④ 회사는 서비스용 설비의 보수, 교체, 정기점검, 공사 등 부득이한 사유로 발생한 손해에 대한 책임이 면제됩니다.
5.	⑤ 회원은 서비스와 관련하여 자신이 회사에 등록한 필수등록 항목(이동전화번호, 또는 아이핀정보 등) 및 비밀번호의 보안에 대하여 책임을 지며, 회사는 회원의 고의나 과실로 인하여 아이디, 비밀번호 등 회원정보가 유출되어 발생하는 손해에 대하여는 책임을 지지 않습니다.
6.	⑥ 회사는 회원의 컴퓨터 오류에 의해 손해가 발생한 경우, 또는 회원이 신상정보 및 전자우편주소를 부실하게 기재하여 손해가 발생한 경우에는 책임을 지지 않습니다.
7.	⑦ 회사는 회원이 서비스를 이용하면서 얻은 자료로 인한 손해에 대하여 책임을 지지 않습니다. 또한 회사는 회원이 서비스를 이용하며 타 회원으로 인해 입게 되는 정신적 피해에 대하여 보상할 책임을 지지 않습니다.
8.	⑧ 회원은 서비스상의 데이터 및 분석자료가 오로지 투자를 위한 정보제공을 목적으로 하는 것이라는 점 및 따라서 투자의 책임은 전적으로 정보를 이용하는 회원에게 있다는 점을 확인합니다.
9.	⑨ 회사는 회원 상호간 및 회원과 제3자간에 서비스를 매개로 발생한 분쟁에 대해 개입할 의무가 없으며, 이로 인한 손해를 배상할 책임이 없습니다.
10.	⑩ 회사는 회원이 서비스상 게재한 각종 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 대하여 책임을 지지 않습니다.
11.	⑪ 회사는 회사의 사이트에 연결되거나 제휴한 업체(타 온라인사이트)에 포함되어 있는 내용의 유효성, 적합성, 법적 합리성, 저작권 준수 여부 등에 책임을 지지 않으며, 이로 인한 어떠한 손해에 대하여도 책임을 지지 않습니다.
제 25 조 (분쟁의 해결)
1.	① 회사와 회원은 서비스와 관련하여 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 하여야 합니다.
2.	② 제1항의 규정에도 불구하고 회사와 회원간에 소송이 제기될 경우, 소송은 민사소송법상의 관할법원에 제기합니다.
부 칙 (2018. 5. 25)
1.	① 이 약관은 2017년 5 월 25 일부터 적용됩니다.


    
</body>
</html>
