(() => {
    const MAX_VISIBLES = 30;
    const reducirMovimiento = window.matchMedia('(prefers-reduced-motion: reduce)').matches;

    const crearZanahoria = (i) => {
        const z = document.createElement('span');
        z.className = 'zanahoria';
        z.style.setProperty('--i', i);
        z.innerHTML =
            '<span class="pieza"><span class="hojas"></span><span class="raiz"></span></span>' +
            '<span class="monton"></span>';
        return z;
    };

    /* ---- Lista: al cosechar, la última zanahoria sale de la tierra
            y después se envía el formulario ---- */
    document.querySelectorAll('form.form-cosecha').forEach((form) => {
        form.addEventListener('submit', (ev) => {
            const bancal = form.closest('.bancal');
            const libres = bancal ? bancal.querySelectorAll('.zanahoria:not(.arrancando)') : [];

            if (libres.length === 0 || reducirMovimiento) return; // envío normal

            ev.preventDefault();
            form.querySelector('button').disabled = true;
            libres[libres.length - 1].classList.add('arrancando');
            setTimeout(() => form.submit(), 950);
        });
    });

    /* ---- Nueva planta: las zanahorias brotan mientras escribes ---- */
    const campoEjemplares = document.getElementById('ejemplares');
    const campoNombre = document.getElementById('nombre');
    const surcos = document.getElementById('vista-surcos');
    const vacio = document.getElementById('vista-vacio');
    const etiquetaNombre = document.getElementById('vista-nombre');

    if (campoEjemplares && surcos) {
        const pintar = () => {
            const n = Math.max(0, Math.min(MAX_VISIBLES, parseInt(campoEjemplares.value, 10) || 0));
            const actuales = surcos.querySelectorAll('.zanahoria').length;

            for (let k = 0; k < n - actuales; k++) {
                surcos.appendChild(crearZanahoria(k));
            }
            for (let k = 0; k < actuales - n; k++) {
                surcos.lastElementChild.remove();
            }

            surcos.hidden = n === 0;
            if (vacio) vacio.hidden = n > 0;
        };

        campoEjemplares.addEventListener('input', pintar);

        if (campoNombre && etiquetaNombre) {
            campoNombre.addEventListener('input', () => {
                etiquetaNombre.textContent = campoNombre.value.trim() || 'Nueva planta';
            });
        }

        pintar();
    }
})();