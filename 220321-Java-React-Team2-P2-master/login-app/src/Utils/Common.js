// return the user data from the session storage
export const getUser = () => {
  const userStr = sessionStorage.getItem('username');
  if (userStr) return JSON.parse(userStr);
  else return null;
}

// return the token from the session storage
export const getToken = () => {
  return sessionStorage.getItem('accessToken') || null;
}

// remove the token and user from the session storage
export const removeUserSession = () => {
  sessionStorage.removeItem('accessToken');
  sessionStorage.removeItem('username');
}

// set the token and user from the session storage
export const setUserSession = (token, user) => {
  sessionStorage.setItem('accessToken', token);
  sessionStorage.setItem('username', JSON.stringify(user));
}