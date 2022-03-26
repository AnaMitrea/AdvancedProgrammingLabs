<html>
<head>
    <title>HTML Report</title>
</head>
<body>
    <h1>HTML Report</h1>
    <h2>The bibliographic references in the catalog are: </h2>
    <#list items as item>
        <ul>
            <li>
                ${item}
            </li>
        </ul>
    </#list>
</body>
</html>

