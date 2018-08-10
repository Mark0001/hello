<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fliud">
	<nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
		<a class="navbar-brand" href="javascript:setCenter()">你的位置</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<div class="form-inline my-2 my-lg-0">
				<input id="searchBox" class="form-control mr-sm-2"
					placeholder="輸入你的想搜尋的地點" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" id="search">搜尋</button>
				<button class="btn btn-outline-default my-2 my-sm-0" id="reset">清除</button>
			</div>
		</div>
	</nav>
</div>