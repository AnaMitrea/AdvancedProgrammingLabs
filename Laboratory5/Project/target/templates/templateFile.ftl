<html>
<head>
    <title>HTML Report</title>
</head>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
    <h1>HTML Report for '${catalog_name}'</h1>
    <h2>The bibliographic references in the catalog are: </h2>
    <table style="width:100%">
        <tr>
            <th>Title</th>
            <th>Id</th>
            <th>Location</th>
            <th>Year</th>
            <th>Author</th>
        </tr>
        <#list items as item>
            <tr>
                <td>${item.title}</td>
                <td>${item.id}</td>
                <td>${item.location}</td>
                <td>${item.year}</td>
                <td>${item.author}</td>
            </tr>
        </#list>
    </table>
</body>
</html>

