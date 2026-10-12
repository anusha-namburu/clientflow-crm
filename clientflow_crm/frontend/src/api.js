const BASE = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api'
async function request(path, options = {}) {
  const response = await fetch(`${BASE}${path}`, {
    headers: { 'Content-Type': 'application/json', ...(options.headers || {}) },
    ...options
  })
  if (!response.ok) {
    const message = await response.text()
    throw new Error(message || `Request failed (${response.status})`)
  }
  if (response.status === 204) return null
  return response.json()
}
export const api = {
  dashboard: () => request('/dashboard'),
  leads: () => request('/leads'),
  createLead: data => request('/leads', { method: 'POST', body: JSON.stringify(data) }),
  updateLeadStatus: (id, status) => request(`/leads/${id}/status`, { method: 'PATCH', body: JSON.stringify({ status }) }),
  deleteLead: id => request(`/leads/${id}`, { method: 'DELETE' }),
  customers: () => request('/customers'),
  createCustomer: data => request('/customers', { method: 'POST', body: JSON.stringify(data) }),
  tasks: () => request('/tasks'),
  createTask: data => request('/tasks', { method: 'POST', body: JSON.stringify(data) })
}
