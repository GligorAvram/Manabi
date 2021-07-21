	function selectDiv() {
		var x = document.getElementById("article-list").value;
		if (x == 1) {
			document.getElementById("predicate").style.display = "block";
			document.getElementById("predicate-words").style.display = "block";
		} else {
			document.getElementById("predicate").style.display = "none";
			document.getElementById("predicate-words").style.display = "none";
		}
		if (x == 2) {
			document.getElementById("subject").style.display = "block";
			document.getElementById("subject-words").style.display = "block";
		} else {
			document.getElementById("subject").style.display = "none";
			document.getElementById("subject-words").style.display = "none";
		}
		if (x == 3) {
			document.getElementById("ha-vs-ga").style.display = "block";
			document.getElementById("ha-vs-ga-words").style.display = "block";
		} else {
			document.getElementById("ha-vs-ga").style.display = "none";
			document.getElementById("ha-vs-ga-words").style.display = "none";
		}
		if (x == 4) {
			console.log("in")
			document.getElementById("copula").style.display = "block";
			document.getElementById("copula-words").style.display = "block";
		} else {
			document.getElementById("copula").style.display = "none";
			document.getElementById("copula-words").style.display = "none";
		}
		if (x == 5) {
			document.getElementById("adjectives").style.display = "block";
			document.getElementById("adjectives-words").style.display = "block";
		} else {
			document.getElementById("adjectives").style.display = "none";
			document.getElementById("adjectives-words").style.display = "none";
		}
		if (x == 6) {
			document.getElementById("particles").style.display = "block";
			document.getElementById("particles-words").style.display = "block";
		} else {
			document.getElementById("particles").style.display = "none";
			document.getElementById("particles-words").style.display = "none";
		}
			if (x == 7) {
			document.getElementById("past-tense-verbs").style.display = "block";
			document.getElementById("past-tense-verbs-words").style.display = "block";
		} else {
			document.getElementById("past-tense-verbs").style.display = "none";
			document.getElementById("past-tense-verbs-words").style.display = "none";
		}
			if (x == 8) {
			document.getElementById("te-form-verbs").style.display = "block";
			document.getElementById("te-form-verbs-words").style.display = "block";
		} else {
			document.getElementById("te-form-verbs").style.display = "none";
			document.getElementById("te-form-verbs-words").style.display = "none";
		}
			if (x == 9) {
			document.getElementById("nai-tai-verbs").style.display = "block";
			document.getElementById("nai-tai-verbs-words").style.display = "block";
		} else {
			document.getElementById("nai-tai-verbs").style.display = "none";
			document.getElementById("nai-tai-verbs-words").style.display = "none";
		}
			if (x == 10) {
			document.getElementById("hoshii").style.display = "block";
			document.getElementById("hoshii-words").style.display = "block";
		} else {
			document.getElementById("hoshii").style.display = "none";
			document.getElementById("hoshii-words").style.display = "none";
		}
			if (x == 11) {
			document.getElementById("potential-form").style.display = "block";
			document.getElementById("potential-form-words").style.display = "block";
		} else {
			document.getElementById("potential-form").style.display = "none";
			document.getElementById("potential-form-words").style.display = "none";
		}
			if (x == 12) {
			document.getElementById("passive-form").style.display = "block";
			document.getElementById("passive-form-words").style.display = "block";
		} else {
			document.getElementById("passive-form").style.display = "none";
			document.getElementById("passive-form-words").style.display = "none";
		}
			if (x == 13) {
			document.getElementById("causative-form").style.display = "block";
			document.getElementById("causative-form-words").style.display = "block";
		} else {
			document.getElementById("causative-form").style.display = "none";
			document.getElementById("causative-form-words").style.display = "none";
		}
			if (x == 14) {
			document.getElementById("te-kureru-ageru").style.display = "block";
			document.getElementById("te-kureru-ageru-words").style.display = "block";
		} else {
			document.getElementById("te-kureru-ageru").style.display = "none";
			document.getElementById("te-kureru-ageru-words").style.display = "none";
		}
			if (x == 15) {
			document.getElementById("i-form-verbs").style.display = "block";
			document.getElementById("i-form-verbs-words").style.display = "block";
		} else {
			document.getElementById("i-form-verbs").style.display = "none";
			document.getElementById("i-form-verbs-words").style.display = "none";
		}
			if (x == 16) {
			document.getElementById("polite-form").style.display = "block";
			document.getElementById("polite-form-words").style.display = "block";
		} else {
			document.getElementById("polite-form").style.display = "none";
			document.getElementById("polite-form-words").style.display = "none";
		}
			if (x == 17) {
			document.getElementById("trans-verbs").style.display = "block";
			document.getElementById("trans-verbs-words").style.display = "block";
		} else {
			document.getElementById("trans-verbs").style.display = "none";
			document.getElementById("trans-verbs-words").style.display = "none";
		}
	}

	let btnRight = document.getElementById("right");
	let btnLeft = document.getElementById("left");
	let article_list = document.getElementById("article-list");
	let maxValue = 17;
	let minValue = 1;

	btnRight.addEventListener('click', () => {		 
		var divNr = parseInt(article_list.value) + 1;
		if (divNr > maxValue) {
			article_list.value = maxValue;
		}
		else if (article_list.value < minValue) {
			article_list.value = minValue;
		}
		else{
			article_list.value = divNr;
		}
		selectDiv();
	})

	btnLeft.addEventListener('click', () => {
		article_list.value = parseInt(article_list.value) - 1;
		if (article_list.value > maxValue) {
			article_list.value = maxValue;
		}
		if (article_list.value < minValue) {
			article_list.value = minValue;
		}
		selectDiv();
	})

