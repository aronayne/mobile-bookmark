<!doctype html>
<html>

    <head>
        <meta charset="utf-8">
        <title>My Page's Title</title>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.css" />
        <link rel="stylesheet" href="/css/custom.css" />
        <script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script>
        <script src="/js/custom.js"></script>
    </head>
    <body>
<div id="page-2" data-role="page">
    <div data-role="header">
        <a href="#" data-icon="arrow-l" data-iconpos="left" data-rel="back" data-transition="slide" data-direction="reverse">Back</a>
        <h1>Add Bookmark</h1>
    </div>
    <div data-role="content">
        <p>Enter Details</p>
<div data-role="fieldcontain">
<label for="name">Book Name:</label>
<input type="text" name="name" id="name" value="" />
</div>
    </div>
    <div data-role="footer" data-position="fixed">
        <div data-role="navbar">
            <ul>
                <li><a href="/page1" data-role="tab" data-icon="grid">View</a></li>
                <li><a href="/page2" data-role="tab" data-icon="grid" class="ui-btn-active">Add</a></li>
                <li><a href="/page3" data-role="tab" data-icon="grid">Edit</a></li>
            </ul>
        </div>
    </div>
</div>
    </body>

</html>