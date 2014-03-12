document.onkeypress = function stopRKey(evt) {
	var evt = (evt) ? evt : ((event) ? event : null);
	var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement
			: null);

	if (evt.keyCode == 13) {
		if ((node.type == "text")) {
			return false;
		}
	}
};

function formatar(src, mask) {
	var i = src.value.length;
	var saida = mask.substring(0, 1);
	var texto = mask.substring(i);
	if (texto.substring(0, 1) != saida) {
		src.value += texto.substring(0, 1);
	}
}

function validateNumber(evt) {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;

	if ((key < 48 || key > 57) && !(key == 8 || key == 9 || key == 13)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault)
			theEvent.preventDefault();
	}
}

function clicar(id, idCampo) {
	if ($("[id*='" + idCampo + "']").val() != '' || idCampo == null) {
		$("[id*='" + id + "']").click();
	}
}

function goToFirst(evt, id, idCampo) {
	var e = event || evt; // for trans-browser compatibility
	var charCode = e.which || e.keyCode;

	// alert(charCode);
	if ($("[id*='" + idCampo + "']").val() != '' || idCampo == null) {
		if (charCode == 9 || charCode == 13) {
			$("[id*='" + id + "']").click();
			return false;
		} else {
			return true;
		}
	} else {
		return true;
	}

	return false;
};

function validaOnBlur(evt) {
	var evt = (evt) ? evt : ((event) ? event : null);

	if (evt.keyCode == 9) {
		return false;
	}

	return true;
}
function incluirItem(evt) {

	var evt = (evt) ? evt : ((event) ? event : null);

	if (evt.keyCode == 9) {
		btnIncluir.jq.click();
	}
}
function setNewFocus() {
	$(
			"div[id='formNovaReceita:receitaItens'] > div:first-child > table:first-child > tbody > tr:last-child > td:first-child >  input")
			.focus();

}

function resetaMedicamento() {
	limparBtn.jq.click();
}

function chamaDialogMedicamento(evt) {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;
	if (key == 9) {
		lupa.jq.click();
	}

}

function limpar(obj) {
	if (obj.value.trim() == "") {
		obj.value = "";
	}

}