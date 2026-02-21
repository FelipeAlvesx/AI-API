import { useState } from "react";
import { triageAPI } from "../services/api";

export default function TriageForm({ patientId, onSuccess }) {
  const [formData, setFormData] = useState({
    age: "",
    symptoms: [],
    medicalHistorySummary: "",
    patientId: patientId || "",
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [symptom, setSymptom] = useState("");

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleAddSymptom = () => {
    if (symptom.trim()) {
      setFormData((prev) => ({
        ...prev,
        symptoms: [...prev.symptoms, symptom],
      }));
      setSymptom("");
    }
  };

  const handleRemoveSymptom = (index) => {
    setFormData((prev) => ({
      ...prev,
      symptoms: prev.symptoms.filter((_, i) => i !== index),
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError(null);

    try {
      const response = await triageAPI.create(formData);
      console.log("Triagem realizada:", response.data);
      onSuccess?.(response.data);
      setFormData({
        age: "",
        symptoms: [],
        medicalHistorySummary: "",
        patientId: patientId || "",
      });
    } catch (err) {
      setError(err.response?.data?.message || "Erro ao realizar triagem");
      console.error("Erro:", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="card">
      <h2 className="text-2xl font-bold text-slate-900 mb-6">
        Triagem de Paciente
      </h2>

      {error && (
        <div className="mb-4 p-4 bg-red-50 text-red-700 rounded-lg border border-red-200">
          {error}
        </div>
      )}

      <form onSubmit={handleSubmit} className="space-y-6">
        <div>
          <label className="block text-sm font-medium text-slate-700 mb-2">
            ID do Paciente
          </label>
          <input
            type="number"
            name="patientId"
            value={formData.patientId}
            onChange={handleInputChange}
            className="input"
            required
          />
        </div>

        <div>
          <label className="block text-sm font-medium text-slate-700 mb-2">
            Idade
          </label>
          <input
            type="number"
            name="age"
            value={formData.age}
            onChange={handleInputChange}
            className="input"
            required
          />
        </div>

        <div>
          <label className="block text-sm font-medium text-slate-700 mb-2">
            Sintomas
          </label>
          <div className="flex gap-2 mb-3">
            <input
              type="text"
              value={symptom}
              onChange={(e) => setSymptom(e.target.value)}
              placeholder="Digite um sintoma"
              className="input"
            />
            <button
              type="button"
              onClick={handleAddSymptom}
              className="btn-secondary px-6"
            >
              Adicionar
            </button>
          </div>

          <div className="flex flex-wrap gap-2">
            {formData.symptoms.map((s, i) => (
              <div
                key={i}
                className="bg-blue-100 text-blue-800 px-3 py-1 rounded-full text-sm flex items-center gap-2"
              >
                {s}
                <button
                  type="button"
                  onClick={() => handleRemoveSymptom(i)}
                  className="text-blue-600 hover:text-blue-800"
                >
                  ✕
                </button>
              </div>
            ))}
          </div>
        </div>

        <div>
          <label className="block text-sm font-medium text-slate-700 mb-2">
            Histórico Médico
          </label>
          <textarea
            name="medicalHistorySummary"
            value={formData.medicalHistorySummary}
            onChange={handleInputChange}
            placeholder="Descreva o histórico médico do paciente"
            className="input min-h-24"
          />
        </div>

        <button
          type="submit"
          disabled={loading}
          className="btn-primary w-full disabled:opacity-50"
        >
          {loading ? "Processando..." : "Realizar Triagem"}
        </button>
      </form>
    </div>
  );
}
