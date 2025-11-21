let currentUser = null;
const apiBase = "http://localhost:8080";

function showSignup(){ document.getElementById('auth-section').style.display='none'; document.getElementById('signup-section').style.display='block'; }
function showLogin(){ document.getElementById('signup-section').style.display='none'; document.getElementById('auth-section').style.display='block'; }

function login(){
    const email = document.getElementById('loginEmail').value;
    const senha = document.getElementById('loginSenha').value;

    fetch(`${apiBase}/auth/login`, { method:"POST", headers:{'Content-Type':'application/json'}, body:JSON.stringify({email, senha}) })
    .then(r=>r.json()).then(data=>{
        if(data.erro) return alert(data.erro);
        currentUser=data;
        document.getElementById('userName').innerText=currentUser.nome;
        document.getElementById('auth-section').style.display='none';
        document.getElementById('app-section').style.display='block';
        document.getElementById('logoutBtn').style.display='inline';
        loadAllData();
    }).catch(err=>console.error(err));
}

function signup(){
    const usuario={
        nome: document.getElementById('signupNome').value,
        idade: parseInt(document.getElementById('signupIdade').value),
        profissao: document.getElementById('signupProfissao').value,
        email: document.getElementById('signupEmail').value,
        senha: document.getElementById('signupSenha').value
    };
    fetch(`${apiBase}/auth/signup`, { method:"POST", headers:{'Content-Type':'application/json'}, body:JSON.stringify(usuario) })
    .then(r=>r.json()).then(data=>{ alert("Usuário cadastrado!"); showLogin(); })
    .catch(err=>console.error(err));
}

function logout(){ currentUser=null; document.getElementById('app-section').style.display='none'; document.getElementById('auth-section').style.display='block'; document.getElementById('logoutBtn').style.display='none'; }

function loadAllData(){ loadUsuarios(); loadTrilhas(); loadCompetencias(); loadSinais(); loadInscricoes(); }

function loadUsuarios(){
    fetch(`${apiBase}/usuarios`).then(r=>r.json()).then(data=>{
        const c=document.getElementById('usuariosList'); c.innerHTML="";
        data.forEach(u=>{ const d=document.createElement('div'); d.className="item"; d.innerText=`${u.id} - ${u.nome} (${u.email})`; c.appendChild(d); });
    });
}

function loadTrilhas(){
    fetch(`${apiBase}/trilhas`).then(r=>r.json()).then(data=>{
        const c=document.getElementById('trilhasList'); c.innerHTML="";
        data.forEach(t=>{ const d=document.createElement('div'); d.className="item"; d.innerText=`${t.id} - ${t.nome} [${t.nivel}] - ${t.cargaHoraria}h`; c.appendChild(d); });
    });
}

function loadCompetencias(){
    fetch(`${apiBase}/competencias`).then(r=>r.json()).then(data=>{
        const c=document.getElementById('competenciasList'); c.innerHTML="";
        data.forEach(cmp=>{ const d=document.createElement('div'); d.className="item"; d.innerText=`${cmp.id} - ${cmp.nome} (${cmp.categoria})`; c.appendChild(d); });
    });
}

function loadSinais(){
    fetch(`${apiBase}/sinais`).then(r=>r.json()).then(data=>{
        const c=document.getElementById('sinaisList'); c.innerHTML="";
        data.forEach(s=>{ const d=document.createElement('div'); d.className="item"; d.innerText=`${s.id} - ${s.dados}`; c.appendChild(d); });
    });
}

function loadInscricoes(){
    fetch(`${apiBase}/inscricoes`).then(r=>r.json()).then(data=>{
        const c=document.getElementById('inscricoesList'); c.innerHTML="";
        data.forEach(i=>{ const d=document.createElement('div'); d.className="item"; d.innerText=`${i.id} - ${i.usuario.nome} inscrito em ${i.trilha.nome} (${i.status})`; c.appendChild(d); });
    });
}

// ------------------ Funções CREATE ------------------
function createUsuario(){
    const u={ nome:document.getElementById('newUsuarioNome').value,
        idade:parseInt(document.getElementById('newUsuarioIdade').value),
        profissao:document.getElementById('newUsuarioProfissao').value,
        email:document.getElementById('newUsuarioEmail').value,
        senha:document.getElementById('newUsuarioSenha').value
    };
    fetch(`${apiBase}/auth/signup`, { method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(u) }).then(r=>r.json()).then(()=>loadUsuarios());
}

function createTrilha(){
    const t={ nome:document.getElementById('newTrilhaNome').value, nivel:document.getElementById('newTrilhaNivel').value, cargaHoraria:parseInt(document.getElementById('newTrilhaCarga').value) };
    fetch(`${apiBase}/trilhas`, { method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(t) }).then(r=>r.json()).then(()=>loadTrilhas());
}

function createCompetencia(){
    const c={ nome:document.getElementById('newCompetenciaNome').value, categoria:document.getElementById('newCompetenciaCategoria').value };
    fetch(`${apiBase}/competencias`, { method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(c) }).then(r=>r.json()).then(()=>loadCompetencias());
}

function createSinal(){
    const s={ dados:document.getElementById('newSinalDados').value };
    fetch(`${apiBase}/sinais`, { method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(s) }).then(r=>r.json()).then(()=>loadSinais());
}

function createInscricao(){
    const usuarioId = parseInt(document.getElementById('newInscricaoUsuarioId').value);
    const trilhaId = parseInt(document.getElementById('newInscricaoTrilhaId').value);

    fetch(`${apiBase}/inscricoes/usuario/${usuarioId}/trilha/${trilhaId}`, {
        method:'POST'
    })
    .then(r => r.json())
    .then(() => loadInscricoes())
    .catch(err => console.error(err));
}

