for(var i = 0; i < 6; i++) { var scriptId = 'u' + i; window[scriptId] = document.getElementById(scriptId); }

$axure.eventManager.pageLoad(
function (e) {

});

u5.style.cursor = 'pointer';
$axure.eventManager.click('u5', function(e) {

if (true) {

	parent.window.close();

}
});
gv_vAlignTable['u1'] = 'center';gv_vAlignTable['u3'] = 'center';