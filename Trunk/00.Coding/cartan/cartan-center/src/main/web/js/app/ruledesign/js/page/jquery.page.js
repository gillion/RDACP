/**
 * The jquery page
 * create date : 2014.11.20
 * Design : liangguichang
 * History
 */
;(function($){
	$.fn.pager = function(options){
		//set up the configure options
		$.fn.pager.defaults = {"pagesize":[10,20,30],"start":0,"length":10,"total":0,"onselectpage":function(i,len){}};
		var opts = $.extend({},$.fn.pager.defaults,options);
		var page={};
		var $pageCtrl={};
		initPage();
		var target = $(this);
		function initPage(){
			//make sure start will inc by length.
			page.start = opts.start;
			page.length = opts.length;
			page.total = opts.total;
			page.currentPage = function(){
				return Math.floor(page.start / page.length + 1);	
			};
			page.totalPage = function(){
				return Math.ceil(page.total / page.length);
			};
			page.nextPage = function(){
				var tryStart = page.start + page.length;
				page.start = tryStart < page.total ? tryStart : start;
			};
			page.firstPage = function(){
				page.start = 0;
				
			};
			page.lastPage = function(){
					page.start = (page.totalPage() - 1) * page.length;
			};
			page.previousPage = function(){
				page.start = page.start - page.length < 0 ? 0 : page.start - page.length;
			};
			page.gotoPage = function(i){
				var tryStart = -1;
				if(i<1) return ;
				if(i<=page.totalPage()){
						tryStart = (i-1) * page.length;
				}
				if(tryStart < page.total && tryStart >=0){
					page.start = tryStart;	
				}
			};
			page.page = function(_page){
				if($.isNumeric(_page.start)){
						page.start = _page.start;
				}
				if($.isNumeric(_page.length)){
					page.length = _page.length;	
				}
				if($.isNumeric(_page.total)){
					page.total = _page.total;	
				}
				if(page.start >=page.total){
					page.start = 0;	
				}
				updateBar($pageCtrl);
			};
		};
		
		function updatePageNoBar(pager)
		{
			$(pager).find(".pageNoBar").html(makePageNoBar());
			// 必须增加绑定click事件
			$(pager).find('.numBtn').on('click',function(){
				var v = $(this).html();
				v = parseInt(v);
				page.gotoPage(v);
				updateBar($(pager),$(pager).find('#__pageNoBar__'));
				opts.onselectpage(page.start,page.length);
			});
		}
		
		function updateBar(pager){
				//$(pager).find('.total').html('共'+page.total+'条记录');
				$(pager).find('.current').html('第'+page.currentPage()+'页');
				$(pager).find('.totalPage').html(page.totalPage());
				$(pager).find('select').val(page.length);
				if(page.start==0){
					$(pager).find('.first').addClass('disabled');
					$(pager).find('.previous').addClass('disabled');
				}else{
					$(pager).find('.first').removeClass('disabled');
					$(pager).find('.previous').removeClass('disabled');	
				}
				
				
				updatePageNoBar(pager);
				
				if(page.totalPage() == page.currentPage()){
					$(pager).find('.next').addClass('disabled');
					$(pager).find('.last').addClass('disabled');
				}else{
					$(pager).find('.next').removeClass('disabled');
					$(pager).find('.last').removeClass('disabled');	
				}
		};
		
		function fmtNum(i)
		{
			if(i<=9)
				return '0'+i;
			return ''+i;
		}
		
		var SHOW=6;
		function makePageNoBar()
		{
			var html="";
			var start = 1;
			var end = 3;
			// 超过6页时，用数字作为页码，中间部分用...代替
			if(page.totalPage()> 6)
			{
				if(page.currentPage() <= page.totalPage() - SHOW/2 && page.currentPage() > SHOW/2)
				{
					start = page.currentPage() - SHOW/2 + 1;
					end = page.currentPage();
				}
				
				for(var i=start;i<=end;i++)
				{
					if(i==page.currentPage())
						html +=			'<a href="javascript:void(0)" class="btn-xs space numBtn pageSelector-current">'+fmtNum(i)+'</a>';
					else
						html +=			'<a href="javascript:void(0)" class="btn-xs space numBtn">'+fmtNum(i)+'</a>';
				}
				if(page.totalPage() - start +1 >SHOW)
					html +=			'<a href="#" class="btn-xs space disabled">...</a>';
				for(var i=page.totalPage()-2;i<=page.totalPage();i++)
				{
					if(i==page.currentPage())
						html +=			'<a href="javascript:void(0)" class="btn-xs space numBtn pageSelector-current">'+fmtNum(i)+'</a>';
					else
						html +=			'<a href="javascript:void(0)" class="btn-xs space numBtn">'+fmtNum(i)+'</a>';
				}
			}
			else if(page.totalPage() > 0)
			{
				for(var i=1;i<= page.totalPage();i++)
				{
					if(i==page.currentPage())
						html +=			'<a href="javascript:void(0)" class="btn-xs space numBtn pageSelector-current">'+fmtNum(i)+'</a>';
					else
						html +=			'<a href="javascript:void(0)" class="btn-xs space numBtn">'+fmtNum(i)+'</a>';
				}
			}
			return html;
		}
		
		function makePager()
		{
			var html = '<div class="pagerBar">';
					html +=   '<div class="pagerLeftBar">';
					html +=			'<span class="space">每页显示记录</span>';
					html +=			getPagerSelector();
					//html +=     '<span class="space total">共'+page.total+'条记录</span>';
					//html +=     '<span class="space current">第'+page.currentPage()+'页</span>';
					html +=			'<a href="javascript:void(0)" class="btn-xs space first">首页</a>';
					html +=			'<a href="javascript:void(0)" class="btn-xs space previous"><上一页</a>';
					html +=		  '<span class="pageNoBar">';
					html +=       makePageNoBar();
					html +=     '</span>';
					html +=			'<a href="javascript:void(0)" class="btn-xs space next">下一页&gt</a>';
					html +=			'<a href="javascript:void(0)" class="btn-xs space last">末页</a>';
					html +=   '</div>';
					html +=   '<div class="pagerRightBar">';
					html +=			'<span class="totalPage-pre">共</span>';
					html +=			'<span class="totalPage">'+page.totalPage()+'</span>';
					html +=			'<span class="totalPage-suf">页</span>';
					html +=			'<span class="space">到第</span>';
					html +=     '<input type="text" size="5" class="gotoInput"></input>';
					html +=			'<span>页</span>';
					html +=			'<input type="button" class="space  submit-btn goto" value="转到"></input>';
					html +=		'</div>';
					html += '</div>';
			var $html = $(html);
		
			$pageCtrl = $html;
			$html.find('select').on('change',function(){
				page.length = parseInt($html.find('select').val());
				page.start=0;
				updateBar($html);
				opts.onselectpage(page.start,page.length);
			});
			$html.find('.first').on('click',function(){
				page.firstPage();
				updateBar($html);
				opts.onselectpage(page.start,page.length);
			});
			$html.find('.previous').on('click',function(){
				page.previousPage();
				updateBar($html);
				opts.onselectpage(page.start,page.length);	
			});
			$html.find('.last').on('click',function(){
				page.lastPage();
				updateBar($html);
				opts.onselectpage(page.start,page.length);
			});
			$html.find('.next').on('click',function(){
				page.nextPage();
				updateBar($html);
				opts.onselectpage(page.start,page.length);
			});
			$html.find('.goto').on('click',function(){
				var v = $html.find('.gotoInput').val();
				v = parseInt(v);
				page.gotoPage(v);
				updateBar($html);
				opts.onselectpage(page.start,page.length);
			});
			
			$html.find('.numBtn').on('click',function(){
				var v = $(this).html();
				v = parseInt(v);
				page.gotoPage(v);
				updateBar($html);
				opts.onselectpage(page.start,page.length);
			});
			target.after($html);
			$html.width(target.outerWidth());
			target.css('margin-bottom','0px');
			target.data('pager',page);
			updateBar($html);
		};
		function getPagerSelector(){
				var html = '<select>';
				for(var i=0;i<opts.pagesize.length;i++){
						html +=	'<option value="'+opts.pagesize[i]+'">'+opts.pagesize[i]+'</option>';	
				}
						html +='</select>';
				return html;
		};
		makePager();
	};
})(jQuery);