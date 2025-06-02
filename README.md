# Pet Manager App

Aplicativo desenvolvido para a disciplina **TSI35B - Programação de Dispositivos Móveis e Sem Fio** na **Universidade Tecnológica Federal do Paraná - Campus Toledo**.  
Professor: Roberto Milton Scheffel  
2ª Avaliação – 2025/1

## Descrição do Projeto

O aplicativo **Pet Manager** permite ao usuário gerenciar informações sobre animais de estimação para doação e adoção, utilizando os web-services REST disponíveis em:

```
http://argo.td.utfpr.edu.br/pets/ws/<recurso>
```

O objetivo principal é facilitar o cadastro, busca e gerenciamento de tipos, raças, cidades e animais, tanto para quem deseja doar quanto para quem deseja adotar um animal.

---

## Funcionalidades

- **Cadastro e gerenciamento de:**
  - Tipos de animal (ex: cachorro, gato, etc.)
  - Raças de animal (relacionadas ao tipo)
  - Cidades
  - Animais (com finalidade de doação ou adoção, e possível valor associado para doação)

- **Busca de animais:**
  - Quem deseja adotar pode buscar animais disponíveis para doação.
  - Quem deseja doar pode buscar interessados cadastrados para adoção.

- **Filtros avançados de busca:**
  - Idade inicial e final do animal
  - Raça
  - Cidade
  - DDD
  - Finalidade (A - adoção, D - doação)
  - Todos os filtros são opcionais.

- **Operações CRUD completas** para todos os recursos (GET, POST, PUT, DELETE).

---

## Padrões de Consumo dos Web Services

- **Listar objetos (GET):**  
  `http://argo.td.utfpr.edu.br/pets/ws/<recurso>`
- **Inserir novo objeto (POST):**  
  Não é necessário informar o `id`, pois o servidor gera automaticamente.
- **Consultar, alterar ou remover objeto específico (GET, PUT, DELETE):**  
  `http://argo.td.utfpr.edu.br/pets/ws/<recurso>/<id>`
- **Relacionamento entre objetos:**  
  Para relacionar (ex: raça com tipo), informe o ID no campo correspondente (ex: `idTipo`).

**Exemplo de cadastro de raça:**
```json
{
  "descricao": "Pastor Alemão",
  "idTipo": 2
}
```

**Exemplo de busca de raças filtrando por tipo:**
```
http://argo.td.utfpr.edu.br/pets/ws/raca?tipo=3
```

**Exemplo de busca de animais com múltiplos filtros:**
```
http://argo.td.utfpr.edu.br/pets/ws/animal?idadeDe=5&idadeAte=120&idTipo=1&ddd=45&finalidade=A&idCidade=2&idRaca=3
```

---

## Requisitos Técnicos

- **Layouts responsivos:**  
  Interfaces otimizadas para orientação vertical e horizontal do dispositivo.

- **Uso de IntentService:**  
  - Para buscas de listas de objetos.
  - Para operações rápidas (buscar, alterar, remover um objeto específico), pode-se usar Thread ou IntentService.

- **Verificação de conexão:**  
  O aplicativo detecta a ausência de conexão com a internet e alerta o usuário, não permitindo o uso offline.

---

## Instalação e Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/<seu-usuario>/<seu-repositorio>.git
   ```
2. **Abra o projeto no Android Studio**
3. **Configure as permissões de internet no AndroidManifest.xml**
4. **Compile e execute no emulador ou dispositivo físico**

---

## Observações

- O servidor gera automaticamente os IDs dos objetos criados via POST.
- Para atualização (PUT), o objeto enviado deve conter o ID original, que deve ser igual ao da URL.
- Relacionamentos entre objetos são feitos por IDs (ex: `idTipo`, `idRaca`, `idCidade`).
- Todos os parâmetros de busca são opcionais nos endpoints.

---
