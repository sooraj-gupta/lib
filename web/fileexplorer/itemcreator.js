var colors = [
	6135733,8498023,7888309,14375000,12819507
];
var maincolor = getRandomUniqueColor();
var hoverfoldercolor = maincolor - 2236962;
document.documentElement.style.setProperty('--main', "#" + maincolor.toString(16) );
document.documentElement.style.setProperty('--maincolorforsharebutton', "#" + maincolor.toString(16) );
document.documentElement.style.setProperty('--hover-folder', "#" + hoverfoldercolor.toString(16) );

var filecolor = getRandomUniqueColor();
var hoverfilecolor = filecolor - 2236962;
document.documentElement.style.setProperty('--file', "#" + filecolor.toString(16) );
document.documentElement.style.setProperty('--hover-file', "#" + hoverfilecolor.toString(16) );

function compact()
{
	localStorage.setItem( "style", "compact");
	setPadding( "item", "3px 0px", "var(--left-padding)");
	setFontSize( "item", "calc( 0.75vw + 10px )" );
	setFontSize( "arrow", "calc( 0.75vw + 6px )" );
	setFontSize( "icon", "calc( 0.75vw + 8px )" );
	setMargin( "item", "5px 0");
	
	document.getElementsByClassName("currentstyle")[0].setAttribute( "class", "stylebutton");
	document.getElementsByClassName("stylebutton")[1].setAttribute( "class", "stylebutton currentstyle");
}


function relax()
{
	localStorage.setItem( "style", "relaxed");
	setPadding( "item", "10px 0px", "var(--left-padding)");
	setFontSize( "item", "calc( 0.75vw + 15px )" );
	setFontSize( "arrow", "calc( 0.75vw + 12px )" );
	setFontSize( "icon", "calc( 0.75vw + 12px )" );
	setMargin( "item", "10px 0");
	
	document.getElementsByClassName("currentstyle")[0].setAttribute( "class", "stylebutton");
	document.getElementsByClassName("stylebutton")[0].setAttribute( "class", "stylebutton currentstyle");
}

function changeColor()
{
	var maincolor = getRandomColor();
	document.documentElement.style.setProperty('--main', "#" + maincolor.toString(16) );
	var hoverfoldercolor = maincolor - 2236962;
	document.documentElement.style.setProperty('--hover-folder', "#" + hoverfoldercolor.toString(16) );
}
function getLocalStorage()
{
	console.log( localStorage.getItem( "style") );
	if( localStorage.getItem( "style") == "compact" )
	{
		compact();
		return;
	}
	relax();
}

function setFontSize( className, fontSize )
{
	var items = document.getElementsByClassName( className );
	for ( var i = 0; i < items.length; i++ )
	{
		items[i].style.fontSize = fontSize;
	}
}
function setMargin( className, margin )
{
	var items = document.getElementsByClassName( className );
	for ( var i = 0; i < items.length; i++ )
	{
		items[i].style.margin = margin;
	}
}
function setPadding( className, padding, paddingLeft )
{
	var items = document.getElementsByClassName( className );
	for ( var i = 0; i < items.length; i++ )
	{
		items[i].style.padding = padding;
		items[i].style.paddingLeft = paddingLeft;
	}
}
var removedColor;
function getRandomUniqueColor()
{
 	var index = Math.floor( Math.random() * colors.length );
	var color = colors[index];
	colors[index] = -1;
	removedColor = color;
	if( color == -1 )
		return getRandomUniqueColor();
	return color;
}

var lastColor = null;
function getRandomColor()
{
	var index = Math.floor( Math.random() * colors.length );
	var color = colors[index];
	if( color == lastColor )
		return getRandomColor();
	if( color == -1 )
	{
		color = removedColor;		
	}
	lastColor = color;
	return color;
}

function openFolder( el )
{
	if( el.nextElementSibling.style.display != "flex" )
	{
		el.nextElementSibling.style.display = "flex";
		el.getElementsByClassName("arrow")[0].style.transform = "rotate(90deg)";
	}

	else
	{
		el.nextElementSibling.style.display = "none";
		el.getElementsByClassName("arrow")[0].style.transform = "rotate(0deg)";
	}

}

function json()
{
	var obj = JSON.parse(items);
	var parent = document.getElementsByTagName("center")[0];
	for( var i = 0;  i < obj.length; i++ )
	{
		createItem( obj[i], parent );
	}
}


function createItem( obj, parent )
{
	if( obj.type == "d" )
	{
		createFolder( obj, parent )
	}
	else if( obj.type == "f" )
	{	
		createFile( obj, parent );
	}
}
function createFolder( obj, parent )
{
	var el = document.createElement( "div" );
	el.className = "folder";
	var title = document.createElement( "div" );
	title.className = "title item";
	title.innerHTML = "<a class = 'arrow'>&#9658;</a>" + "&nbsp;&nbsp;" + "<img class = 'icon' src = 'https://img.icons8.com/ios/452/opened-folder.png'>" + "&nbsp;" + obj.name;
	title.setAttribute( "onclick", "openFolder(this)" );
	parent.appendChild( el );
	el.appendChild( title );

	var cont = document.createElement( "div" );
	cont.className = "folder-contents";
	el.appendChild( cont );

	for ( var i = 0; i < obj.content.length; i++ )
	{
		createItem( obj.content[i], cont );
	}
}

function createFile( obj, parent )
{
	var el = document.createElement( "div" );
	el.className = "file item";
	var title = document.createElement( "div" );
	el.innerHTML =  "<img class = 'icon' src = 'https://webstockreview.net/images/circle-clipart-chain-link-9.png'>" + "&nbsp;" + obj.name;
	el.setAttribute( "onclick", "goTo(\"" +obj.link+ "\" );" );
	parent.appendChild( el );
	if( obj.name == "index.html" )
	{
		el.style.width = "calc( 55% - var(--left-padding) )";
		el.style.borderBottomRightRadius = "0px";
		el.style.borderTopRightRadius = "0px";
		var emb = document.createElement("div");
		emb.className = "link item";
		emb.innerHTML = "View";
		emb.setAttribute( "onclick", `goTo( '${obj.local}');`);
		parent.appendChild(emb);
	}
}

function goTo( link )
{
	window.location = link;
}
json();
getLocalStorage();
