<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/incluseTag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
</script>
<script defer
	src="https://maps.googleapis.com/maps/api/js?key=${googleMapApiKey}&callback=initMap">
</script>
<script type="text/javascript">
	var map;
	function initMap() {

		var markerData;
		var markers = [];
		getUbikeInfo().done(function(res) {
			markerData = res.data;
			console.log(res);
			var position = {
				lat : 25.047045,
				lng : 121.516547
			};
			map = new google.maps.Map(document.getElementById('map'), {
				center : position,
				zoom : 17
			});

			for (var i = 0; i < markerData.length; i++) {
				var mposition = {
					lat : markerData[i].positionLat,
					lng : markerData[i].positionLon
				}
				
				var marker = new google.maps.Marker({
					position : mposition,
					map : map,
					name : markerData[i].stationName_Zh_tw
				});
				
				marker.addListener('click', function() {
					alert(this.name);
			    });
				markers.push(marker);
			}
			// var marker = new google.maps.Marker({
			//    	position: position,
			//    	map: map
			//    });
			var markerCluster = new MarkerClusterer(
					map,
					markers,
					{
						imagePath : 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'
			});
		});

		

	}

	function getUbikeInfo() {
		var url = "/hello/ubike/info";

		return $.ajax(url);
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/navBar.jsp"%>
	<div id="map" class="container-fluid mainBlock"></div>

</body>
</html>
