<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/incluseTag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script defer
      src="https://maps.googleapis.com/maps/api/js?key=${googleMapApiKey}&callback=initMap">
    </script>
<script type="text/javascript">
var map;
function initMap() {
	var position = {lat: 25.047045, lng: 121.516547};
	map = new google.maps.Map(document.getElementById('map'), {
		center: position,
		zoom: 17
 	});
	var marker = new google.maps.Marker({
    	position: position,
    	map: map
    });
}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/navBar.jsp"%>
	<div id="map" class="container-fluid mainBlock">
			
	</div>
	
</body>
</html>
