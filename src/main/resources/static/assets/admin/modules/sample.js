/**

 @Name：layuiAdmin 主页示例
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：GPL-2
    
 */


layui.define(function(exports){
  var admin = layui.admin;

  //区块轮播切换
  layui.use(['admin', 'carousel'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,carousel = layui.carousel
    ,element = layui.element
    ,device = layui.device();

    //轮播切换
    $('.layadmin-carousel').each(function(){
      var othis = $(this);
      carousel.render({
        elem: this
        ,width: '100%'
        ,arrow: 'none'
        ,interval: othis.data('interval')
        ,autoplay: othis.data('autoplay') === true
        ,trigger: (device.ios || device.android) ? 'click' : 'hover'
        ,anim: othis.data('anim')
      });
    });
    element.render('progress');
  });

  layui.use(['carousel', 'echarts','sysdata'], function(){
    var $ = layui.$
    ,carousel = layui.carousel
    ,sysdata=layui.sysdata
    ,echarts = layui.echarts;
    var arr=[];
      $.ajax({
          type: "GET",
          url:"/sys/franchisee/getRegion",
          dataType: "json",
          beforeSend: function () {
          },
          success: function (data) {
              for (var i=0;i<data.length;i++){
                  arr.push(data[i]);
              }
              localStorage.removeItem("arr");
              localStorage.setItem("arr",arr);
          },
      });
      function getTimes(city){
          var arr=localStorage.getItem("arr").split(",");
          var times=0;
          for(var i=0;i<arr.length;i++){
              var str=arr[i];
            var patt=new RegExp(city);
              if(patt.test(str)){
                  times++;//数组中有相同值就加1
              }
          }
          return times;
      }
         var echartsApp = [], options = [
             {
                 title : {
                     text: '全国的加盟商分布',
                     subtext: '按省划分'
                 },
                 tooltip : {
                     trigger: 'item'
                 },
                 dataRange: {
                     orient: 'horizontal',
                     min: 0,
                     max: 20,
                     text:['高','低'],
                     splitNumber:0
                 },
                 series : [
                     {
                         name: '该省的加盟商人数',
                         type: 'map',
                         mapType: 'china',
                         selectedMode : 'multiple',
                         itemStyle:{
                             normal:{label:{show:true}},
                             emphasis:{label:{show:true}}
                         },
                         data:[
                             {name:'西藏', value:getTimes("西藏")},
                             {name:'青海', value:getTimes("青海")},
                             {name:'宁夏', value:getTimes("宁夏")},
                             {name:'海南', value:getTimes("海南")},
                             {name:'甘肃', value:getTimes("甘肃")},
                             {name:'贵州', value:getTimes("贵州")},
                             {name:'新疆', value:getTimes("新疆")},
                             {name:'云南', value:getTimes("云南")},
                             {name:'重庆', value:getTimes("重庆")},
                             {name:'吉林', value:getTimes("吉林")},
                             {name:'山西', value:getTimes("山西")},
                             {name:'天津', value:getTimes("天津")},
                             {name:'江西', value:getTimes("江西")},
                             {name:'广西', value:getTimes("广西")},
                             {name:'陕西', value:getTimes("陕西")},
                             {name:'黑龙江', value:getTimes("黑龙江")},
                             {name:'内蒙古', value:getTimes("内蒙古")},
                             {name:'安徽', value:getTimes("安徽")},
                             {name:'北京', value:getTimes("北京")},
                             {name:'福建', value:getTimes("福建")},
                             {name:'上海', value:getTimes("上海")},
                             {name:'湖北', value:getTimes("湖北")},
                             {name:'湖南', value:getTimes("湖南")},
                             {name:'四川', value:getTimes("四川")},
                             {name:'辽宁', value:getTimes("辽宁")},
                             {name:'河北', value:getTimes("河北")},
                             {name:'河南', value:getTimes("河南")},
                             {name:'浙江', value:getTimes("浙江")},
                             {name:'山东', value:getTimes("山东")},
                             {name:'江苏', value:getTimes("江苏")},
                             {name:'广东', value:getTimes("广东")}
                         ]
                     }
                 ]
             }
         ]
             ,elemDataView = $('#LAY-index-pagethree').children('div')
             ,renderDataView = function(index){
             echartsApp[index] = echarts.init(elemDataView[index], layui.echartsTheme);
             echartsApp[index].setOption(options[index]);
             window.onresize = echartsApp[index].resize;
         };


      //没找到DOM，终止执行
    if(!elemDataView[0]) return;
 
    renderDataView(0);  
  });
  //项目进展
  exports('sample', {})
});