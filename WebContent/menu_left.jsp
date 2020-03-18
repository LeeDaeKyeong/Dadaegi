<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>master</title>
<style>
* {
	padding: 0;
	margin: 0;
}
h2{
	text-align : center;
}
a{
	text-decoration: none;
}
body {
	font-size: 9pt;
}

#accordionMenu1 {
	margin: 10px auto;
	width: 200px;
}

.acc-menu {
	position: relative;
	list-style: none;
	border: 4px solid #eee;
}

.acc-menu>li {
	overflow: hidden;
	border: 1px solid #000;
	cursor: pointer;
}

.acc-menu li .main-title {
	background-color: #fff;
	padding: 10px;
	vertical-align: middle;
	position: relative;
	z-index: 100;
}

.acc-menu li .main-title a {
	display: inline-block;
	height: 20px;
	line-height: 20px;
	text-align: center;
	vertical-align: middle;
}

.acc-menu li .main-title .folder {
	display: inline-block;
	width: 20px;
	height: 20px;
	overflow: hidden;
	line-height: 20px;
	text-align: center;
	vertical-align: middle;
	margin-right: 5px;
	text-indent: -100px;
	background-image:
		url("http://cfile3.uf.tistory.com/image/24185E335762538E2AE110");
	/* 기본은 .close */
	background-position: 0 -40px;
}

.acc-menu li .main-title .folder.empty {
	background-position: 0 0;
}

.acc-menu li .main-title .folder.open {
	background-position: 0 -20px;
}

.acc-menu li .main-title .folder.close {
	background-position: 0 -40px;
}

.acc-menu li ul.sub {
	list-style: none;
	margin-left: 30px;
	margin-bottom: 20px;
	z-index: 90;
	position: relative;
}

.acc-menu li ul.sub.open {
	display: block;
}

.acc-menu li ul.sub.hide {
	display: none;
}

.acc-menu li ul.sub li {
	height: 20px;
	padding: 10px;
	line-height: 20px;
	vertical-align: middle;
	cursor: pointer;
}

.acc-menu li ul.sub li.select {
	background-color: #bddeea;
}

footer {
	background-color: #222;
	color: #fff;
	font-size: 14px;
	bottom: 0;
	position: fixed;
	left: 0;
	right: 0;
	text-align: center;
	z-index: 999;
}

footer p {
	margin: 10px 0;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida  Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

footer .fa-heart {
	color: red;
}

footer .fa-dev {
	color: #fff;
}

footer .fa-twitter-square {
	color: #1da0f1;
}

footer .fa-instagram {
	color: #f0007c;
}

fotter .fa-linkedin {
	color: #0073b1;
}

footer .fa-codepen {
	color: #fff
}

footer a {
	color: #3c97bf;
	text-decoration: none;
	margin-right: 5px;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		// 인스턴스 생성
		var accordion = new AccordionMenu('.acc-menu');
		//accordion.selectMenu(1, 1, true);

		// 애니메이션 타입으로 0번째 메뉴 열기
		accordion.openSubMenuAt(0, true);

		// 즉시 2번째 메뉴 닫기
		//accordion.closeSubMenuAt(2, false);

		accordion.$accordionMenu.on('open', function(e) {
			console.log('open', e.$target.find('.main-title a').text());
		});

		accordion.$accordionMenu.on('close', function(e) {
			console.log('close', e.$target.find('.main-title a').text());
		});

		accordion.$accordionMenu.on('selected', function(e) {
			var oldText = '없음';

			if (e.$oldItem) {
				oldText = e.$oldItem.text();
			}
			console.log('select old = ', oldText + ', new = '
					+ e.$newItem.text());
		});

	});

	function AccordionMenu(selector) {
		// 프로퍼티 생성 및 초기화
		this.$accordionMenu = null; // 메뉴 랩퍼를 담을 변수
		this.$mainMenuItems = null; // 메인 메뉴아이템을 담을 변수
		this.$selectSubItem = null; // 선택할 서브 메뉴아이템을 담을 변수

		this.init(selector);
		this.initSubMenuPanel();
		this._initEvent();
	}

	AccordionMenu.prototype = {
		// 요소 초기화
		'init' : function(selector) {
			this.$accordionMenu = $(selector);
			this.$mainMenuItems = this.$accordionMenu.children('li');

		},

		// 서브 패널 초기화 - 초기 시작시 닫힌 상태로 만들기
		'initSubMenuPanel' : function() {
			var _self = this;
			this.$mainMenuItems.each(function(index) {
				var $item = $(this), $subMenu = $item.find('.sub');

				// 서브 메뉴가 없는 경우
				if (!$subMenu.length) {
					$item.attr('data-extension', 'empty');
				} else {
					if ($item.attr('data-extension') == 'open') {
						_self.openSbuMenu($item);
					} else {
						if ($item.attr('data-extension') == 'open') {
							_self.openSbuMenu('$item', false);
						} else {
							_self.closeSubMenu($item, false);
						}
					}
				}

			});
		},

		// 아이콘 상태 설정
		'setIconState' : function($item, state) {
			var $folder = $item.find('.main-title .folder');
			// 기존 클래스를 모두 제거
			$folder.removeClass();
			$folder.addClass('folder ' + state);
		},

		// 이벤트 초기화
		'_initEvent' : function() {
			var _self = this, $mainTitle = this.$mainMenuItems
					.find('.main-title'), $subPanelItem = this.$mainMenuItems
					.find('.sub li');

			$mainTitle.on('click', function(e) {
				var $item = $(this).parent();
				_self._toggleSubMenuPanel($item);
			});

			$subPanelItem.on('click', function(e) {
				var $this = $(this);
				_self.selectSubMenuItem($this)
			});

		},

		// 서브 메뉴패널 열기 - animation 기본값은 true
		'openSbuMenu' : function($item, animation) {
			if ($item != null) {
				$item.attr('data-extension', 'open');
				var $subMenu = $item.find('.sub');

				if (!animation) {
					$subMenu.css({
						'margin-top' : 0
					});
				} else {
					$subMenu.stop().animate({
						'margin-top' : 0
					}, 300);
				}

				// 아이콘 상태를 open(-) 상태로 만들기
				this.setIconState($item, 'open');

				// 사용자 정의 open 이벤트 발생
				this.dispatchEvent($item, 'open');

			}
		},

		// 서브 메뉴패널 닫기
		'closeSubMenu' : function($item, animation) {
			if ($item != null) {
				$item.attr('data-extension', 'close');
				var $subMenu = $item.find('.sub'), subMenuPanelHeight = -$subMenu
						.outerHeight(true);

				if (!animation) {
					$subMenu.css({
						'margin-top' : subMenuPanelHeight
					});
				} else {
					$subMenu.stop().animate({
						'margin-top' : subMenuPanelHeight
					}, 300);
				}

				// 아이콘 상태를 close(+) 상태로 만들기
				this.setIconState($item, 'close');

				// 사용자 정의 close 이벤트 발생
				this.dispatchEvent($item, 'close');

			}
		},

		// 서브 메뉴패널 열고 닫기
		'_toggleSubMenuPanel' : function($item) {
			var extension = $item.attr('data-extension');

			// 서브 메뉴패널이 없는 경우 실행하지 않는다.
			if (extension == 'empty') {
				return;
			}

			// 서브 메뉴 패널이 있는 경우에 실행
			if (extension == 'open') {
				this.closeSubMenu($item, true);
			} else {
				this.openSbuMenu($item, true);
			}
		},

		// 인덱스 메뉴의 서브 메뉴패널 열기
		'openSubMenuAt' : function(index, animation) {
			var $item = this.$mainMenuItems.eq(index);
			this.openSbuMenu($item, animation);
		},

		// 인덱스 메뉴의 서브 매뉴패널 닫기
		'closeSubMenuAt' : function(index, animation) {
			var $item = this.$mainMenuItems.eq(index);
			this.closeSubMenu($item, animation);
		},

		// 서브 메뉴아이템 선택
		'selectSubMenuItem' : function($item) {
			var $oldItem = this.$selectSubItem;
			if (this.$selectSubItem != null) {
				this.$selectSubItem.removeClass('select');
			}
			this.$selectSubItem = $item;
			this.$selectSubItem.addClass('select');

			// 사용자 정의 select 이벤트 발생
			this._dispatchSelectEvent($oldItem, this.$selectSubItem);
		},

		// 인덱스를 활용한 메인 메뉴아이템과 서브 메뉴아이템 선택 기능
		'selectMenu' : function(mainIndex, subIndex, animation) {
			// 메인 메뉴아이템
			var $item = this.$mainMenuItems.eq(mainIndex);

			// 서브 메뉴아이템
			var $subMenuItem = $item.find('.sub li').eq(subIndex);
			// 서브 메뉴아이템이 존재하는 경우에만 처리
			if ($subMenuItem) {
				// 서브 메뉴패널 열기
				this.openSbuMenu($item, animation);
				// 서브 메뉴아이템 선택
				this.selectSubMenuItem($subMenuItem);
			}
		},

		// 사용자 정의 open, close 이벤트 발생 처리
		'dispatchEvent' : function($item, eventName) {
			var customEvent = jQuery.Event(eventName);
			customEvent.$target = $item;

			this.$accordionMenu.trigger(customEvent);
		},

		// 사용자 정의 select 이벤트 발생 처리
		'_dispatchSelectEvent' : function($oldItem, $newItem) {
			var customEvent = jQuery.Event('selected');
			customEvent.$oldItem = $oldItem;
			customEvent.$newItem = $newItem;

			this.$accordionMenu.trigger(customEvent);
		}

	};
</script>
</head>

<body>
	<h2>컵씨네</h2>
	<ul class="acc-menu" id="accordionMenu1">
		<li>
			<div class="main-title">
				<a href="dashboard.sa">대시보드</a>
			</div>
		</li>
		<li data-extension="close">
			<div class="main-title">
				<span class="folder"> </span><a>상품관리</a>
			</div>
			<ul class="sub">
				<li><a href="list.pro?product_code=cake">컵씨들</a></li>
				<li><a href="list.pro?product_code=drink">음료씨들</a></li>
				<li><a href="addForm.pro">상품추가</a></li>
				<li><a href="stock.pro">재고관리</a></li>
			</ul>
		</li>
		<li data-extension="close">
			<div class="main-title">
				<span class="folder"> </span><a>판매관리</a>
			</div>
			<ul class="sub">
				<li><a href="order.sa">주문조회</a></li>
				<li><a href="reservation.sa">예약조회</a></li>
			</ul>
		</li>
		<li data-extension="close">
			<div class="main-title">
				<span class="folder"> </span><a>정산관리</a>
			</div>
			<ul class="sub">
				<li><a href="calculate.ca">총 매출</a></li>
			</ul>
		</li>
		<li>
			<div class="main-title">
				<span class="folder"> </span><a>문의/리뷰관리</a>
			</div>
			<ul class="sub">
				<li><a href="reviewlist.qn">상품리뷰답변</a></li>
				<li><a href="questionlist.qn">상품문의답변</a></li>
			</ul>
		</li>
		<li>
			<div class="main-title">
				<span class="folder"> </span><a>고객혜택관리</a>
			</div>
			<ul class="sub">
				<li><a>고객등급관리</a></li>
				<li><a>적립금관리</a></li>
			</ul>
		</li>
		<li>
			<div class="main-title">
				<span class="folder"> </span><a>회원관리</a>
			</div>
			<ul class="sub">
				<li><a>회원상세보기</a></li>
			</ul>
		</li>
	</ul>
	<footer>
		<p>Master Mode</p>
	</footer>
</body>
</html>