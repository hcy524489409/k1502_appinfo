<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增APP基础信息 <i class="fa fa-user"></i><small>${devUser.devname}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
	  <!-- <div class="item form-group">
               <label class="control-label col-md-3 col-sm-3 col-xs-12" ></label>
               <div class="col-md-6 col-sm-6 col-xs-12">
                 <form action="uploadlogo" class="dropzone" style="height:100px;">
                 </form>
            <div class="clearfix"></div>
         </div>
       </div> -->
           <div class="clearfix"></div>
        <form class="form-horizontal form-label-left" action="/app/add" method="post" enctype="multipart/form-data">

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwarename">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" class="form-control col-md-7 col-xs-12" 
               data-validate-length-range="20" data-validate-words="1" name="softwarename"  required="required"
               placeholder="请输入软件名称" type="text">
            </div>
          </div>

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkname">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" class="form-control col-md-7 col-xs-12" 
              	data-validate-length-range="20" data-validate-words="1" name="apkname"   required="required"
              	placeholder="请输入APK名称" type="text">
              <span id="APKNameInfo"></span>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supportrom">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportROM" class="form-control col-md-7 col-xs-12" name="supportrom"
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入支持的ROM" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfacelanguage">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" 
              data-validate-length-range="20" data-validate-words="1" name="interfacelanguage"   required="required"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwaresize">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwareSize" name="softwaresize"   required="required" onkeyup="value=value.replace(/[^\d]/g,'')"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads"   required="required"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="flatformid">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="flatformid" id="flatformId" class="form-control"   required="required">
                <option value="0">==请选择==</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categorylevel1">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel1" id="categoryLevel1" class="form-control"   required="required">
                <option value="0">==请选择==</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="categorylevel2">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel2" id="categoryLevel2" class="form-control"  required="required">
                <option value="0">==请选择==</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categorylevel3">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel3" id="categoryLevel3" class="form-control"  required="required">
                <option value="0">==请选择==</option>
              </select>
            </div>
          </div>

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" name="status" id="status" value="1">待审核
            </div>
          </div>

          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appinfo">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appinfo"     required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>

           <div class="item form-group">
             <img src="" id="echoImg" width="20%" /><%--图片回显--%>
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="a_logoPicPath">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="hidden" name="logopicpath" />
            <input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath"  required="required" id="a_logoPicPath"/>
            ${fileUploadError }
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath}/statics/js/jquery.form.js"></script>
<script>

  //异步加载 所属平台  一级、二级、三级分类
  $(function () {

      //给APKname表单项添加一个失去焦点事件
      $("#APKName").blur(function () {
          //发送异步请求之前，先拿到当前表单的值
          var apkValue = $(this).val();

          //开始发送异步请求，去后台验证用户输入的名称是否已经存在
          $.ajax({
              url:"/app/verificationAPKName",
              data:{apkname:apkValue},
              success:function (data) {
                  //后台返回的验证结果
                  if(data.success){
                      $("#APKNameInfo").html(data.success).css("color","green");
                  }else if(data.error){
                      $("#APKNameInfo").html(data.error).css("color","red");
                  }

              },
              error:function () {
                  console.log("验证失败");
              }
          });

      });


      //1.加载一级分类
      $.ajax({
          url:"/category/list",
          data:{parentId:0},
          success:function (data) {
              //1.清空二级和三级分类信息
              $("#categoryLevel2>option:gt(0)").remove();
              $("#categoryLevel3>option:gt(0)").remove();
              //2.把从后台返回的数据拼接到字符串中去
              var options = "";

              //遍历数组
              for(var i =0 ; i < data.length; i++ ){

                  options += "<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
              }


              //3.把拼接的字符串添加到一级分类的下拉列表框中
              $("#categoryLevel1").append(options);

          },
          error:function () {
              console.log("加载失败");
          }
      })

      //当改变一级分类的值的时候，加载对应的二级分类列表
      $("#categoryLevel1").change(function () {
          var parentId = $(this).val();
          //如果父级id的值不等于0，才发送异步请求，不然请求的数据有问题
          //1.清空二级和三级分类下拉框中的内容
          $("#categoryLevel2>option:gt(0)").remove();
          $("#categoryLevel3>option:gt(0)").remove();

          if(parentId != 0){
              //发送ajax请求
              $.ajax({
                  url:"/category/list",
                  data:{parentId:parentId},
                  success:function (data) {

                      var options = "";
                      //遍历数据
                      for(var i = 0 ; i < data.length; i++ ){
                          options += "<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
                      }

                      //加载数据在二级分类下拉框中
                      $("#categoryLevel2").append(options);
                  },
                  error:function () {
                      console.log("二级分类加载失败");
                  }
              });
          }
      });

      //当二级分类改变的时候，加载对应的三级分类的内容
      $("#categoryLevel2").change(function () {
          var parentId = $(this).val();
          //清空三级分类下拉框
          $("#categoryLevel3>option:gt(0)").remove();
          if(parentId != 0){
              $.ajax({
                  url:"/category/list",
                  data:{parentId:parentId},
                  success:function (data) {
                      var options="";

                      //遍历数据
                      for(var i = 0; i < data.length ; i++){
                          options += "<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
                      }
                      //把数据写入到三级下拉框中
                      $("#categoryLevel3").append(options);

                  },
                  error:function () {
                      console.log("三级分类加载失败");
                  }
              });
          }
      });


      //加载所属平台的数据
      $.ajax({
          url:"/data/dictionary",
          data:{typename:"所属平台"},
          success:function (data) {
              //创建一个字符串，把需要的数据拼接到这个字符串中
              var options = "";

              //遍历拿到的数据
              for(var i =0 ; i < data.length ; i++){
                  options += "<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>";
              }

              //把数据添加到所属平台的下拉框中
              $("#flatformId").append(options);
              // flatformId
          },
          error:function () {
              console.log("所属平台加载失败");
          }
      });

  })












</script>