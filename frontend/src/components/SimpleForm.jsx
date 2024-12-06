import React, { useState } from "react";

function SimpleForm() {
    const [formData, setFormData] = useState({
        name: '',
    }); 
    const [serverMessage, setServerMessage] = useState('');
    
    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData, 
            [name]: value,
        });
    };

    const handleSubmit = async(e) => {
        e.preventDefault(); 
        const requestData = {
            name: formData.name,
        }; 
        try {
            const response = await fetch("http://localhost:8080/web4/echo", {
                method: "POST", 
                headers: {
                    "Content-Type": "application/json",
                }, 
                body: JSON.stringify(requestData),
            }); 
            if (response.ok) {
                const result = await response.json(); 
                setServerMessage(result.message);
            }
        } catch (error) {
            setServerMessage(error.message);
        }
    }; 

    return (
        <div>
            <h2>simple echo</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="name">name </label>
                    <input 
                        type="text" 
                        id="name"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                {serverMessage && <p className="server-message">{serverMessage}</p>}
                <button type="submit" className="submit-button">
                    Send
                </button>
            </form>

        </div>
    );
}
export default SimpleForm;