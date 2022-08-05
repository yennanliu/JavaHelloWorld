<html>
<header></header>
<body>
    <h1>Hello, ${name}!</h1>

    <#-- 多層資料結構 -->
    The first book: ${books[0].name}

    <#-- 字串處理 -->
    User location: ${location?upper_case}

    <#-- 數字格式化 -->
    Cash: ${cash?string.currency}

    <#-- 日期格式化 -->
    Created Date: ${createdDate?string["yyyy-MM-dd"]}

    <#-- if else 邏輯處理 -->
    <#if (cash > 100000)>
    Rich
    <#else>
    Make more money
    </#if>

    <#-- for迴圈取出資料 -->
    <#list books as book>
    ${book?counter}: ${book.name}, written by ${book.author}
    </#list>
</body>
<#-- 匯入其它樣版內容 -->
<#-- <#include "footer.ftl"> -->
</html>