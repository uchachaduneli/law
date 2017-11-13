function caseequredFields(formVar) {
    if (formVar.identNumber.$error.required) {
        errorMsg('საიდენტიფიკაციო ნომრის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.name.$error.required) {
        errorMsg('დასახელების მითითება სავალდებულოა');
        return false;
    }
    if (formVar.descriptionKa.$error.required) {
        errorMsg('ქართული აღწერის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.descriptionEn.$error.required) {
        errorMsg('ინგლისური აღწერის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.descriptionRu.$error.required) {
        errorMsg('რუსული აღწერის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.addressKa.$error.required) {
        errorMsg('ქართულად მისამართის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.addressRu.$error.required) {
        errorMsg(' რუსულად მისამართის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.addressEn.$error.required) {
        errorMsg(' ინგლისურად მისამართის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.workingStart.$error.required && $("input[name=workingStart]").val().length === 0) {
        errorMsg('სამუშაოს დაწყების დროის მითითება სავალდებულოა');
        return false;
    }
    if (formVar.workingEnd.$error.required && $("input[name=workingEnd]").val().length === 0) {
        errorMsg('სამუშაოს დასრულების დროის მითითება სავალდებულოა');
        return false;
    }

    return true;
}