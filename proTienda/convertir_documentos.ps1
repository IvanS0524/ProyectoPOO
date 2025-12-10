# =======================================================================
# Script de Conversión de Documentos - Proyecto POO
# =======================================================================
# Este script automatiza la conversión de documentos Markdown a Word
# usando Pandoc
# =======================================================================

Write-Host ""
Write-Host "=============================================" -ForegroundColor Cyan
Write-Host "  CONVERSOR DE DOCUMENTOS - PROYECTO POO" -ForegroundColor Cyan
Write-Host "=============================================" -ForegroundColor Cyan
Write-Host ""

# Verificar si Pandoc está instalado
Write-Host "Verificando instalación de Pandoc..." -ForegroundColor Yellow
$pandocInstalled = Get-Command pandoc -ErrorAction SilentlyContinue

if (-not $pandocInstalled) {
    Write-Host ""
    Write-Host "ERROR: Pandoc no está instalado" -ForegroundColor Red
    Write-Host ""
    Write-Host "Pandoc es necesario para convertir archivos Markdown a Word." -ForegroundColor Yellow
    Write-Host ""
    Write-Host "Opciones:" -ForegroundColor Cyan
    Write-Host "1. Instalar Pandoc desde: https://pandoc.org/installing.html" -ForegroundColor White
    Write-Host "2. Usar conversión manual (copiar/pegar a Word)" -ForegroundColor White
    Write-Host ""
    Read-Host "Presiona Enter para salir"
    exit
}

Write-Host "✓ Pandoc está instalado" -ForegroundColor Green
Write-Host ""

# Cambiar al directorio del proyecto
$scriptPath = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $scriptPath

Write-Host "Directorio actual: $scriptPath" -ForegroundColor Cyan
Write-Host ""

# Crear carpeta de salida si no existe
$outputDir = Join-Path $scriptPath "docs\output"
if (-not (Test-Path $outputDir)) {
    New-Item -ItemType Directory -Path $outputDir | Out-Null
    Write-Host "✓ Carpeta de salida creada: $outputDir" -ForegroundColor Green
} else {
    Write-Host "✓ Carpeta de salida existe: $outputDir" -ForegroundColor Green
}
Write-Host ""

# Archivos a convertir
$archivos = @(
    @{
        Nombre = "Contexto del Proyecto"
        Entrada = "docs\1_Contexto_del_Proyecto.md"
        Salida = "docs\output\1_Contexto_del_Proyecto.docx"
    },
    @{
        Nombre = "Desarrollo del Proyecto"
        Entrada = "docs\2_Desarrollo_del_Proyecto.md"
        Salida = "docs\output\2_Desarrollo_del_Proyecto.docx"
    },
    @{
        Nombre = "Presentación"
        Entrada = "docs\Presentacion.md"
        Salida = "docs\output\Presentacion.docx"
    }
)

# Contador de éxitos
$exitosos = 0
$totales = $archivos.Count

# Convertir cada archivo
Write-Host "Iniciando conversión de documentos..." -ForegroundColor Cyan
Write-Host ""

foreach ($archivo in $archivos) {
    Write-Host "Procesando: $($archivo.Nombre)..." -ForegroundColor Yellow
    
    # Verificar que el archivo de entrada existe
    if (-not (Test-Path $archivo.Entrada)) {
        Write-Host "  ✗ Error: Archivo no encontrado: $($archivo.Entrada)" -ForegroundColor Red
        continue
    }
    
    # Realizar la conversión
    try {
        pandoc $archivo.Entrada -o $archivo.Salida
        
        if ($LASTEXITCODE -eq 0) {
            Write-Host "  ✓ Convertido exitosamente" -ForegroundColor Green
            Write-Host "    Archivo: $($archivo.Salida)" -ForegroundColor Gray
            $exitosos++
        } else {
            Write-Host "  ✗ Error en la conversión" -ForegroundColor Red
        }
    } catch {
        Write-Host "  ✗ Error: $($_.Exception.Message)" -ForegroundColor Red
    }
    
    Write-Host ""
}

# Resumen
Write-Host "=============================================" -ForegroundColor Cyan
Write-Host "  RESUMEN DE CONVERSIÓN" -ForegroundColor Cyan
Write-Host "=============================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Total de archivos procesados: $totales" -ForegroundColor White
Write-Host "Conversiones exitosas: $exitosos" -ForegroundColor Green
Write-Host "Conversiones fallidas: $($totales - $exitosos)" -ForegroundColor $(if ($exitosos -eq $totales) { "Green" } else { "Red" })
Write-Host ""

if ($exitosos -eq $totales) {
    Write-Host "¡Todas las conversiones fueron exitosas!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Los archivos convertidos se encuentran en:" -ForegroundColor Cyan
    Write-Host "  $outputDir" -ForegroundColor White
    Write-Host ""
    Write-Host "Próximos pasos:" -ForegroundColor Yellow
    Write-Host "  1. Abre los archivos .docx en Word" -ForegroundColor White
    Write-Host "  2. Revisa el formato y ajusta si es necesario" -ForegroundColor White
    Write-Host "  3. Inserta las capturas de pantalla en el documento de desarrollo" -ForegroundColor White
    Write-Host "  4. Guarda los documentos finales" -ForegroundColor White
} else {
    Write-Host "Algunas conversiones fallaron." -ForegroundColor Yellow
    Write-Host "Verifica los mensajes de error arriba." -ForegroundColor Yellow
    Write-Host ""
    Write-Host "Alternativa:" -ForegroundColor Cyan
    Write-Host "  Puedes abrir los archivos .md en VS Code" -ForegroundColor White
    Write-Host "  Seleccionar todo (Ctrl+A), copiar (Ctrl+C)" -ForegroundColor White
    Write-Host "  Y pegar en un documento nuevo de Word" -ForegroundColor White
}

Write-Host ""
Write-Host "=============================================" -ForegroundColor Cyan
Write-Host ""

Read-Host "Presiona Enter para salir"
