export default function TriageResult({ data }) {
  if (!data) return null;

  const getUrgencyColor = (urgency) => {
    switch (urgency) {
      case "HIGH":
        return "bg-red-50 border-red-200 text-red-900";
      case "MEDIUM":
        return "bg-yellow-50 border-yellow-200 text-yellow-900";
      case "LOW":
        return "bg-green-50 border-green-200 text-green-900";
      default:
        return "bg-slate-50 border-slate-200";
    }
  };

  const getUrgencyBadgeColor = (urgency) => {
    switch (urgency) {
      case "HIGH":
        return "bg-red-100 text-red-700";
      case "MEDIUM":
        return "bg-yellow-100 text-yellow-700";
      case "LOW":
        return "bg-green-100 text-green-700";
      default:
        return "bg-slate-100 text-slate-700";
    }
  };

  return (
    <div className={`card border-2 ${getUrgencyColor(data.urgency)}`}>
      <div className="flex items-start justify-between mb-6">
        <h3 className="text-xl font-bold">Resultado da Triagem</h3>
        <span
          className={`px-3 py-1 rounded-full text-sm font-medium ${getUrgencyBadgeColor(data.urgency)}`}
        >
          {data.urgency}
        </span>
      </div>

      <div className="space-y-4">
        <div>
          <p className="text-sm font-medium text-slate-600 mb-1">
            Especialidade Recomendada
          </p>
          <p className="text-lg font-semibold text-slate-900">
            {data.specialty}
          </p>
        </div>

        <div>
          <p className="text-sm font-medium text-slate-600 mb-1">Motivo</p>
          <p className="text-slate-700">{data.reason}</p>
        </div>

        {data.trace && (
          <div className="mt-6 pt-6 border-t border-slate-200">
            <p className="text-xs font-medium text-slate-500 mb-3">
              Informações Técnicas
            </p>
            <div className="grid grid-cols-2 gap-4 text-sm">
              <div>
                <p className="text-slate-600">Provider</p>
                <p className="font-mono text-slate-800">
                  {data.trace.provider}
                </p>
              </div>
              <div>
                <p className="text-slate-600">Latência</p>
                <p className="font-mono text-slate-800">
                  {data.trace.latencyMs}ms
                </p>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
