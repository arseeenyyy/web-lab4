import React, { useState } from "react";

function RegistrationForm() {
    const [formData, setFormData] = useState({
        login: '',
        password: '',
    });
    const [errorMessage, setErrorMessage] = useState('');
    const [successMessage, setSuccessMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const requestData = {
            login: formData.login,
            password: formData.password,
        };

        try {
            const response = await fetch("http://localhost:8080/web4/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(requestData), 
            });

            if (response.ok) {
                const result = await response.json(); 
                setSuccessMessage(result.message || "Registration successful");
            } else {
                const result = await response.json();
                setErrorMessage(result.message || "Something went wrong");
            }
        } catch (error) {
            setErrorMessage("Network error: " + error);
        }
    };

    return (
        <div className="form-container">
            <h2>User registration</h2>
            <form className="registration-form" onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="login">login </label>
                    <input
                        type="text"
                        id="login"
                        name="login"
                        value={formData.login}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password </label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                {successMessage && <p className="success-message">{successMessage}</p>}
                {errorMessage && <p className="error-message">{errorMessage}</p>}
                <button type="submit" className="submit-button">
                    Send
                </button>
            </form>
        </div>
    );
}

export default RegistrationForm;
