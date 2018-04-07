<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/2/21
  Time: 上午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<link href = "<%=basePath%>css/bootstrap.min.css" rel="stylesheet"/>
<script src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>js/echarts.js"></script>
</head>
<body>
<div style = "
    width: 700px;
    height: 706px;
    margin:0 auto;
    border:1px solid #b9def0;
    ">
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>过磅时间</th>
            <th>种类</th>
            <th>重量 </th>
            <th>供应商</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th name="date" ondblclick="tst(event)" scope="row">1</th>
            <td><select><option >水稳 1#（19-26.5）</option><option >水稳 2#（9.5-19）</option><option >水稳 3#（4.75-9.5）</option><option >水稳 4#（2.36-4.75）</option><option >水稳 5#（0-2.36）</option><option >油面 1#（16-26.5）</option><option >油面 2#（9.5-16）</option><option >油面 3#（4.75-9.5）</option><option >油面 5#（0-2.36）</option></select></td>
            <td ondblclick="tst(event)" name="weighing" class="weighing">43.19</td>
            <td name="vendor"ondblclick="tst(event)">20170304</td>
        </tr>
        <tr>
            <th name="date" ondblclick="tst(event)" scope="row">1</th>
            <td><select><option >水稳 1#（19-26.5）</option><option >水稳 2#（9.5-19）</option><option >水稳 3#（4.75-9.5）</option><option >水稳 4#（2.36-4.75）</option><option >水稳 5#（0-2.36）</option><option >油面 1#（16-26.5）</option><option >油面 2#（9.5-16）</option><option >油面 3#（4.75-9.5）</option><option >油面 5#（0-2.36）</option></select></td>
            <td ondblclick="tst(event)" name="weighing" class="weighing">43.22</td>
            <td name="vendor" ondblclick="tst(event)">20170404</td>
        </tr>
        <tr>
            <th name="date" ondblclick="tst(event)" scope="row">1</th>
            <td><select><option >水稳 1#（19-26.5）</option><option >水稳 2#（9.5-19）</option><option >水稳 3#（4.75-9.5）</option><option >水稳 4#（2.36-4.75）</option><option >水稳 5#（0-2.36）</option><option >油面 1#（16-26.5）</option><option >油面 2#（9.5-16）</option><option >油面 3#（4.75-9.5）</option><option >油面 5#（0-2.36）</option></select></td>
            <td ondblclick="tst(event)" name="weighing" class="weighing">43.29</td>
            <td name="vendor" ondblclick="tst(event)">20170504</td>
        </tr>
        </tbody>

    </table>
    <button  id="addRaw"  class="btn btn-default" >添加一行</button>
    <button id = "isOk"   class="btn btn-default">确认</button>
    <button id = "removeRaw"   class="btn btn-default">删除一行</button>
</div>
<br/>
<br/>
<br/>
<div id="main" style="width: 530px;height: 500px"></div>
<div id="main_" style="height:350px;"></div>
<script type = "text/javascript">
    function removeRaw(obj){$('#removeRaw').on('click',function(){$(obj).remove()})};
    function submit(){
        console.log("isok");
        var data = [];
        var weighing_select =document.getElementsByTagName("select");
        for(var i =0 ;i<document.getElementsByName("weighing").length;i++){
            console.log("js 测试"+document.getElementsByName("weighing")[i].textContent);
            console.log(document.getElementsByName("weighing").length);
            // console.log(weighing_select[0].options.item(0).textContent);
            // console.log(weighing_select[0].options(document.getElementsByTagName("select")[0].selectedIndex).text);

            console.log(weighing_select[i].options.item(document.getElementsByTagName("select")[i].selectedIndex).textContent);

        }

        return "index.html";
    }
    function tst(event){
        event = event ? event : window.event;
        var obj = event.srcElement ? event.srcElement : event.target;
        obj.setAttribute("contentEditable","true");
    }
    $(document).ready(function(){
        $.ajax({url:"display_.html",async:false,dataType:"json",success:function (data) {
                var data1 = [];
                var data2 = [];
                for(var i = 0;i<31;i++){if(data[i]!=null){data1.push(data[i].sheer_weight_sum);data2.push(data[i].weighing_date)}else{continue}}
                console.log("测试成功"+data[0].sheer_weight_sum);
                var echart = echarts.init(document.getElementById('main_'));
                echart.setOption({
                    title:{text:'7月水稳碎石进量（单位：吨）'},
                    tooltip:{},
                    xAxis:{type:'category',axisLabel:{interval:0, rotate:30 },data:data2},
                    yAxis: {type:'value'},
                    series:[{data:data1,label:{normal:{show:true}},type:"line"}],
                    //控制图形
                    grid:{x:50,x2:40,y:60,y2:65},
                })
                echart.resize();
            }});
        $.ajax({url:"display.html",async:false,dataType:"json",success:function(data){   console.log("success ok"+data[0].stone_categories,'utf-8');
                alert("success ok"+data[0].stone_categories,'utf-8');
                var echart = echarts.init(document.getElementById('main'));
                var data_=['7月','8月','9月','10月','11月','12月','13月','14月','15月','16月','17月','18月','19月','20月','21月'];
                echart.setOption({
                    title: {
                        textStyle: {
                            fontSize: 13
                        },
                        text: '7月巴中恒昌建材\t水稳碎石进量(单位：吨)'
                    },
                    tooltip: {},
                    legend: {
                         type:'scroll',
                        //orient: 'horizentail',
                        right: 0,
                        top: 20,
                        bottom: 20,
                        textStyle: {
                            fontSize: 7
                        },
                        selectedMode: 'single',
                        data:['7月','8月','9月','10月']
                    },
                    //formatter:function(val){    return val.split("-").join("\n");},//此语句是让legend 中的文字进行换行</span>
                    xAxis: {
                        data: ["1#\n（19-26.5）","2#\n（9.5-19）","3#\n（4.75-9.5）","4#\n（2.36-4.75）","5#\n（0-2.36）"]
                    },
                    yAxis: {},
                    series: [{
                        name: '7月',
                        type: 'bar',
                        data: [data[0], data[1], data[2], data[3], data[4]],
                        label:{normal:{show:true}}
                    },{name:'8月',type:'bar',data:[111,111]},{name:'9月',type:'bar',data:[111,111]},{name:'10月',type:'bar',data:[111,111,111,111,111]}],
                    grid:{x:40,x2:30,y2:200}
                });
            }});
        $('tbody').on('click','tr',function(){$(this).toggleClass('red').siblings().removeClass('red');removeRaw(this)});
        $('#addRaw').on('click',function(){
             var trlen = $('table').find('tr').length;
             if(trlen<=17){$('tbody').append('<tr><th name="date" ondblclick="tst(event)" scope="row">1</th><td><select class="additionalSelect"><option >水稳 1#（19-26.5）</option><option >水稳 2#（9.5-19）</option><option >水稳 3#（4.75-9.5）</option><option >水稳 4#（2.36-4.75）</option><option >水稳 5#（0-2.36）</option><option >油面 1#（16-26.5）</option><option >油面 2#（9.5-16）</option><option >油面 3#（4.75-9.5）</option><option >油面 5#（0-2.36）</option></select></td><td ondblclick="tst(event)" name="weighing">43.12</td><td name="vendor" ondblclick="tst(event)">@mdo</td></tr>')}
             if(trlen>17){$('#addRaw').css('pointer-events:none');}
        });
        // $('td').on('dblclick', function(){
        //     $(this).attr('contentEditable','true');
        //
        // });
        $('body').on('click','#isOk', function(){
            var data=[];
            for(var i=0;i<$('td[name="weighing"]').length;i++){
                console.log("I 的 次数"+i);
                console.log($('select').find("option:selected")[i].text,$('td[name="weighing"]')[i].textContent);
                // console.log("附加的下拉选项"+$('.additionalSelect').find("option:selected").val())
                //"categories",$('select').find("option:selected").text(),"weighing",$('td[name="weighing"]').text()
                // console.log($('th[name="date"]')[i].textContent);
                // console.log($('td[name="vendor"]')[i].textContent);
                data.push({"categories":$('select').find("option:selected")[i].textContent,"weighing":$('td[name="weighing"]')[i].textContent,"date":$('th[name="date"]')[i].textContent,"vendor":$('td[name="vendor"]')[i].textContent});
            }
            alert(data);

            $.ajax({url:"test.html",async:false,dataType:"json",data:{ds:JSON.stringify(data)}});

        });

    })
</script>
<style type="text/css">
    .red{background-color: rgba(68, 64, 64, 0.36)
    }
</style>
</body>
</html>

