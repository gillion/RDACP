for(var i = 0; i < 4; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});

u3.style.cursor = 'pointer';
$axure.eventManager.click('u3', function(e) {

if (true) {

	parent.window.close();

}
});
gv_vAlignTable['u1'] = 'top';
u2.style.cursor = 'pointer';
$axure.eventManager.click('u2', function(e) {

if (true) {

	parent.window.close();

}
});
