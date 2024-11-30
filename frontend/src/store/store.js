import { createStore } from 'redux';

// Начальное состояние
const initialState = {
  message: '',
  response: ''
};

// Редьюсер
function reducer(state = initialState, action) {
  switch (action.type) {
    case 'SET_MESSAGE':
      return { ...state, message: action.payload };
    case 'SET_RESPONSE':
      return { ...state, response: action.payload };
    default:
      return state;
  }
}

// Создание хранилища
const store = createStore(reducer);

export default store;
