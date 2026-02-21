import { useState } from "react";
import TriageForm from "./components/TriageForm";
import AppointmentForm from "./components/AppointmentForm";
import TriageResult from "./components/TriageResult";
import "./index.css";

function App() {
  const [activeTab, setActiveTab] = useState("triage");
  const [triageResult, setTriageResult] = useState(null);
  const [notification, setNotification] = useState(null);

  const handleTriageSuccess = (result) => {
    setTriageResult(result);
    showNotification("Triagem realizada com sucesso!", "success");
  };

  const handleAppointmentSuccess = (result) => {
    showNotification("Consulta agendada com sucesso!", "success");
  };

  const showNotification = (message, type) => {
    setNotification({ message, type });
    setTimeout(() => setNotification(null), 4000);
  };

  return (
    <div className="min-h-screen bg-slate-50">
      {/* Header */}
      <header className="bg-white shadow-sm border-b border-slate-200">
        <div className="max-w-7xl mx-auto px-6 py-6">
          <div className="flex items-center gap-3">
            <div className="w-10 h-10 bg-blue-600 rounded-lg flex items-center justify-center">
              <span className="text-white font-bold text-lg">⚕️</span>
            </div>
            <div>
              <h1 className="text-2xl font-bold text-slate-900">MediAI</h1>
              <p className="text-sm text-slate-600">
                Sistema Inteligente de Triagem e Agendamentos
              </p>
            </div>
          </div>
        </div>
      </header>

      {/* Notifications */}
      {notification && (
        <div
          className={`fixed top-6 right-6 p-4 rounded-lg text-white ${
            notification.type === "success" ? "bg-green-500" : "bg-red-500"
          }`}
        >
          {notification.message}
        </div>
      )}

      {/* Main Content */}
      <main className="max-w-7xl mx-auto px-6 py-12">
        {/* Tabs */}
        <div className="flex gap-2 mb-8 border-b border-slate-200">
          <button
            onClick={() => setActiveTab("triage")}
            className={`px-6 py-3 font-medium border-b-2 transition-colors ${
              activeTab === "triage"
                ? "border-blue-600 text-blue-600"
                : "border-transparent text-slate-600 hover:text-slate-900"
            }`}
          >
            Triagem
          </button>
          <button
            onClick={() => setActiveTab("appointment")}
            className={`px-6 py-3 font-medium border-b-2 transition-colors ${
              activeTab === "appointment"
                ? "border-blue-600 text-blue-600"
                : "border-transparent text-slate-600 hover:text-slate-900"
            }`}
          >
            Agendar Consulta
          </button>
        </div>

        {/* Content Grid */}
        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
          {/* Form Column */}
          <div className="lg:col-span-2">
            {activeTab === "triage" && (
              <TriageForm onSuccess={handleTriageSuccess} />
            )}
            {activeTab === "appointment" && (
              <AppointmentForm onSuccess={handleAppointmentSuccess} />
            )}
          </div>

          {/* Results Column */}
          <div>
            {triageResult && activeTab === "triage" && (
              <TriageResult data={triageResult} />
            )}
            {activeTab === "appointment" && (
              <div className="card text-center text-slate-600">
                <p className="mb-4">
                  Preencha o formulário para agendar uma consulta.
                </p>
                <div className="text-3xl">📅</div>
              </div>
            )}
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;
