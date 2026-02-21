import { useState } from "react";
import { appointmentAPI } from "../services/api";

export default function AppointmentForm({ onSuccess }) {
  const [formData, setFormData] = useState({
    patientId: "",
    specialty: "",
    date: "",
    time: "",
    notes: "",
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const specialties = [
    "Gastroenterology",
    "Cardiology",
    "Neurology",
    "General Practice",
    "Pediatrics",
    "Orthopedics",
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError(null);

    try {
      const response = await appointmentAPI.create(formData);
      console.log("Agendamento realizado:", response.data);
      onSuccess?.(response.data);
      setFormData({
        patientId: "",
        specialty: "",
        date: "",
        time: "",
        notes: "",
      });
    } catch (err) {
      setError(err.response?.data?.message || "Erro ao agendar consulta");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2 className="text-2xl font-bold text-slate-900 mb-6">
        Agendar Consulta
      </h2>

      {error && (
        <div className="mb-4 p-4 bg-red-50 text-red-700 rounded-lg border border-red-200">
          {error}
        </div>
      )}

      <form onSubmit={handleSubmit} className="space-y-6">
        <div className="grid grid-cols-2 gap-4">
          <div>
            <label className="block text-sm font-medium text-slate-700 mb-2">
              ID do Paciente
            </label>
            <input
              type="number"
              name="patientId"
              value={formData.patientId}
              onChange={handleChange}
              className="input"
              required
            />
          </div>

          <div>
            <label className="block text-sm font-medium text-slate-700 mb-2">
              Especialidade
            </label>
            <select
              name="specialty"
              value={formData.specialty}
              onChange={handleChange}
              className="input"
              required
            >
              <option value="">Selecione uma especialidade</option>
              {specialties.map((s) => (
                <option key={s} value={s}>
                  {s}
                </option>
              ))}
            </select>
          </div>
        </div>

        <div className="grid grid-cols-2 gap-4">
          <div>
            <label className="block text-sm font-medium text-slate-700 mb-2">
              Data
            </label>
            <input
              type="date"
              name="date"
              value={formData.date}
              onChange={handleChange}
              className="input"
              required
            />
          </div>

          <div>
            <label className="block text-sm font-medium text-slate-700 mb-2">
              Horário
            </label>
            <input
              type="time"
              name="time"
              value={formData.time}
              onChange={handleChange}
              className="input"
              required
            />
          </div>
        </div>

        <div>
          <label className="block text-sm font-medium text-slate-700 mb-2">
            Anotações
          </label>
          <textarea
            name="notes"
            value={formData.notes}
            onChange={handleChange}
            placeholder="Informações adicionais..."
            className="input min-h-24"
          />
        </div>

        <button
          type="submit"
          disabled={loading}
          className="btn-primary w-full disabled:opacity-50"
        >
          {loading ? "Agendando..." : "Agendar Consulta"}
        </button>
      </form>
    </div>
  );
}
