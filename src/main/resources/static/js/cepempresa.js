   $(document).ready(function() {
        function limpa_formulário_cep() {
            // Limpa valores do formulário de cep.
            $("#EmpInputEndereco").val("");
            $("#bairro").val("");
            $("#EmpInputCidade").val("");
            $("#EmpInputUf").val("");
            $("#ibge").val("");
        }
        
        //Quando o campo cep perde o foco.
        $("#EmpCep").blur(function() {
            //Nova variável "cep" somente com dígitos.
            var cep = $(this).val().replace(/\D/g, '');
            //Verifica se campo cep possui valor informado.
            if (cep != "") {
                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;
                //Valida o formato do CEP.
                if(validacep.test(cep)) {
                    //Preenche os campos com "..." enquanto consulta webservice.
                    $("#EmpInputEndereco").val("...");
                    $("#bairro").val("...");
                    $("#EmpInputCidade").val("...");
                    $("#EmpInputUf").val("...");
                    $("#ibge").val("...");
                    //Consulta o webservice viacep.com.br/
                    $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
                        if (!("erro" in dados)) {
                            //Atualiza os campos com os valores da consulta.
                            $("#EmpInputEndereco").val(dados.logradouro);
                            $("#bairro").val(dados.bairro);
                            $("#EmpInputCidade").val(dados.localidade);
                            $("#EmpInputUf").val(dados.uf);
                            $("#ibge").val(dados.ibge);
                        } //end if.
                        else {
                            //CEP pesquisado não foi encontrado.
                            limpa_formulário_cep();
                            alert("CEP não encontrado.");
                        }
                    });
                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        });
    });
   
   //editar
   
   $(document).ready(function() {
       function limpa_formulário_cep() {
           // Limpa valores do formulário de cep.
           $("#EmpEditEndereco").val("");
           $("#bairro").val("");
           $("#EmpEditCidade").val("");
           $("#EmpEditUf").val("");
           $("#ibge").val("");
       }
       
       //Quando o campo cep perde o foco.
       $("#EmpEditCep").blur(function() {
           //Nova variável "cep" somente com dígitos.
           var cep = $(this).val().replace(/\D/g, '');
           //Verifica se campo cep possui valor informado.
           if (cep != "") {
               //Expressão regular para validar o CEP.
               var validacep = /^[0-9]{8}$/;
               //Valida o formato do CEP.
               if(validacep.test(cep)) {
                   //Preenche os campos com "..." enquanto consulta webservice.
                   $("#EmpEditEndereco").val("...");
                   $("#bairro").val("...");
                   $("#EmpEditCidade").val("...");
                   $("#EmpEditUf").val("...");
                   $("#ibge").val("...");
                   //Consulta o webservice viacep.com.br/
                   $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
                       if (!("erro" in dados)) {
                           //Atualiza os campos com os valores da consulta.
                           $("#EmpEditEndereco").val(dados.logradouro);
                           $("#bairro").val(dados.bairro);
                           $("#EmpEditCidade").val(dados.localidade);
                           $("#EmpEditUf").val(dados.uf);
                           $("#ibge").val(dados.ibge);
                       } //end if.
                       else {
                           //CEP pesquisado não foi encontrado.
                           limpa_formulário_cep();
                           alert("CEP não encontrado.");
                       }
                   });
               } //end if.
               else {
                   //cep é inválido.
                   limpa_formulário_cep();
                   alert("Formato de CEP inválido.");
               }
           } //end if.
           else {
               //cep sem valor, limpa formulário.
               limpa_formulário_cep();
           }
       });
   });