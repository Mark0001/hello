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
		getUbikeStation().then(function(res) {
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
					title: markerData[i].stationName_Zh_tw,
					stationData : markerData[i]
				});
				
				marker.addListener('click', function(event) {
					// alert(this.name);
					// alert(this.stationData.city + "_" + this.stationData.stationUID);
					var stationData = this.stationData;
					getStationService(stationData.city,stationData.stationUID).done(function(res){
						console.log(res);
 						var contentString  = "";
 						contentString += "站點名稱：" + stationData.stationName_Zh_tw + "<br>";
 						contentString += "剩餘車位：" + res.data.availableRentBikes + "<br>";
 						contentString += "可還車位：" + res.data.availableReturnBikes  + "<br>";

						var infowindow = new google.maps.InfoWindow({
          					content: contentString
        				});
        				infowindow.setPosition(event.latLng);
  						infowindow.open(map);
					});
					map.setCenter(this.getPosition());
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

	function getUbikeStation() {
		return new Promise(function(resolve, reject){
			var data = localStorage.getItem("ubikeStation");
			if(data != null){
				resolve(JSON.parse(data));
			}else{
				var url = "/hello/ubike/stationInfo";
				$.ajax(url).done(function(res){
					localStorage.setItem("ubikeStation",JSON.stringify(res));
	            	resolve(res);
	        	})
			}
	    });
	}

	function getStationService(city,stationId){
		var url = "/hello/ubike/serviceInfo";
		return $.ajax({
			url : url,
			data : {
				city : city,
				stationId :　stationId
			}
		})
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/navBar.jsp"%>
	<div id="map" class="container-fluid mainBlock"></div>

</body>
</html>
