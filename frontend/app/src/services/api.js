import axios from "axios";

const API_BASE = import.meta.env.VITE_API_URL || "http://localhost:8080";

const api = axios.create({
  baseURL: API_BASE,
  headers: {
    "Content-Type": "application/json",
  },
});

export const triageAPI = {
  create: (data) => api.post("/triage", data),
};

export const appointmentAPI = {
  list: () => api.get("/appointments"),
  create: (data) => api.post("/appointments", data),
  getById: (id) => api.get(`/appointments/${id}`),
};

export const userAPI = {
  create: (data) => api.post("/users", data),
  getById: (id) => api.get(`/users/${id}`),
};

export default api;
