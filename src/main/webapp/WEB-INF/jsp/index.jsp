<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>



<html>
<head>
    <title>佳旅联合内部系统</title>

    <style>
        a{
            color: blue;
        }
    </style>
    <script>
        if('${msg}' != ''){
            alert('${msg}');
        }

        function  checkForm() {
            var sysNtype = document.getElementById("sysNtype").value;
            sysNtype = sysNtype==1?"地接":sysNtype==2?"专线":sysNtype==3?"组团":"直营";
            var makeSure = confirm("确定是"+sysNtype+"系统吗?");
            if(!makeSure) return false;

            var sysCreateuser = document.getElementById("sysCreateuser").value;
            var sysCpyname = document.getElementById("sysCpyname").value;
            var sysCpyid = document.getElementById("sysCpyid").value;

            if(''!= sysCpyid){
                var reg_type = /^[0-9]*[1-9][0-9]*$/;
                if(!reg_type.test(sysCpyid)){
                    alert("企业ID必须数字");
                    return false;
                }
            }

            if(sysCpyname==''){
                alert("必须填写企业名称");
                return false;
            }
            if(sysCreateuser==''){
                alert("必须填写提交人");
                return false;
            }
            return true;
        }
        
//        function updateForm(id) {
//            if(confirm("确定已经解决了么?")){
//                window.location = "/work/order/update?id="+id;
//            }
//        }
    </script>
</head>
<body>
<div>
    <div>
        <form method="post" action="/work/order/insert" id="form1" onsubmit="return checkForm();">
            <table>
                <tr>
                    <td>系统类型</td>
                    <td>
                        <select style="width: 132px;" name="sysNtype" id="sysNtype">
                            <option value="1">地接</option>
                            <option value="2">专线</option>
                            <option value="3">组团</option>
                            <option value="4">直营</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>企业ID</td>
                    <td><input type="text" name="sysCpyid"  id="sysCpyid"/></td>
                    <td>企业名称</td>
                    <td><input type="text" name="sysCpyname" id="sysCpyname"/><span style="color:red;">*</span></td>
                </tr>
                <tr>
                    <td>登录账号</td>
                    <td><input type="text" name="sysUser"/></td>
                    <td>登录密码</td>
                    <td><input type="text" name="sysPas" /></td>
                </tr>
                <tr>
                    <td>提交人</td>
                    <td><input type="text" name="sysCreateuser" id="sysCreateuser"/><span style="color:red;">*</span></td>
                </tr>
                <tr>
                    <td>修改内容</td>
                    <td colspan="3">
                        <textarea name="sysRemark" cols="55" rows="10"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" style="text-align: center">
                        <input type="submit" value="提交" />
                    </td>
                </tr>
            </table>
        </form>
    </div>


    <div>

        <table border="1" width="100%">
            <tr>
                <td>序号</td>
                <td>系统类型</td>
                <td>企业ID</td>
                <td>企业名称</td>
                <td>登录账号</td>
                <td>登录密码</td>
                <td>提交人</td>
                <td>提交时间</td>
                <td>修改内容</td>
                <td>是否解决</td>
                <td>解决时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${workOrder}" var="item" varStatus="idx">
                <c:if test="${item.sysIsUpdate == 0}">
                    <tr style="color: red">
                </c:if>
                <c:if test="${item.sysIsUpdate == 2}">
                    <tr style="color: gray">
                </c:if>
                <c:if test="${item.sysIsUpdate == 1}">
                    <tr>
                </c:if>
                    <td>${item.id}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.sysNtype == '1'}">
                                地接
                            </c:when>
                            <c:when test="${item.sysNtype == '2'}">
                                专线
                            </c:when>
                            <c:when test="${item.sysNtype == '4'}">
                                直营
                            </c:when>
                            <c:when test="${item.sysNtype == '3'}">
                                组团
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                    </td>
                    <td>${item.sysCpyid}</td>
                    <td>${item.sysCpyname}</td>
                    <td>${item.sysUser}</td>
                    <td>${item.sysPas}</td>
                    <td>${item.sysCreateuser}</td>
                    <td><fmt:formatDate value="${item.sysCreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${item.sysRemark}</td>
                    <td>
                        <c:if test="${item.sysIsUpdate == 0}">
                            未解决
                        </c:if>
                        <c:if test="${item.sysIsUpdate == 1}">
                            已解决
                        </c:if>
                        <c:if test="${item.sysIsUpdate == 2}">
                            关闭
                        </c:if>
                    </td>
                    <td><fmt:formatDate value="${item.sysUpdatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>
                        <a href="/work/order/delete?id=${item.id}">关闭</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
