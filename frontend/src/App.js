import React from 'react';
import { useSelector, useDispatch } from 'react-redux';

function App() {
  const message = useSelector((state) => state.message);
  const response = useSelector((state) => state.response);
  const dispatch = useDispatch();

  const handleChange = (e) => {
    dispatch({ type: 'SET_MESSAGE', payload: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      const res = await fetch('http://localhost:8080/web4/echo', {
        method: 'POST',
        headers: { 'Content-Type': 'text/plain' },
        body: message
      });
      const text = await res.text();
      dispatch({ type: 'SET_RESPONSE', payload: text });
    } catch (error) {
      dispatch({ type: 'SET_RESPONSE', payload: 'Ошибка сервера' });
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Эхо-сервер</h1>
      <input
        type="text"
        value={message}
        onChange={handleChange}
        placeholder="Введите текст"
        style={{ padding: '10px', width: '300px' }}
      />
      <button onClick={handleSubmit} style={{ marginLeft: '10px', padding: '10px 20px' }}>
        Отправить
      </button>
      <div style={{ marginTop: '20px' }}>
        <strong>Ответ от сервера:</strong>
        <p>{response}</p>
      </div>
    </div>
  );
}

export default App;
