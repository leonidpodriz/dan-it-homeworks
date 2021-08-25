export const getFormData = (formElement) => {
    return Object.fromEntries(new FormData(formElement).entries())
};

export const handleFormControlChange = (setValue) => (event) => {
    setValue(event.target.value);
}