var working = false;

$(document).ready(function () {
	
	$("#saveFornecimento").click(function(){
	   $.ajax({
          type: "POST",
          url: "save",
          data: $('#fornecimento33').serialize()
      }).done(function(data){
		$("#jsGrid").jsGrid("insertItem", data);
		$('#closeModal').click();
	});
	})
	
	tableProduto();

	$('#porcentagemButton').click(function(){
		procedimentoProduto();
	});
	
});


function procedimentoProduto()
{
	  $.ajax({
          type: "POST",
          url: "procedimentoproduto",
          data: $('#porcentagem').serialize()
      }).done(function()
      {
    	  tableProduto();
      });

}

function tableProduto()
{
	
	  $("#procedimentoProduto").jsGrid({
		    autoload: true,
		    inserting: false,
		    editing: false,
		    width: "100%",
		    controller: {
		    	 loadData: function ()
		    	 {
		    		 return $.ajax({
		             type: "POST",
		             url: "getproduto",
		             async: false,
		             success: function(data) {
		            	 working = true;
		             }
		         });
		    	}
		    },
		    
		    fields: [
		        { name: "codProduto", type: "text", width: 150, validate: "required", title: "Código Produto"},
		        { name: "valorVenda", type: "text", width: 150, validate: "required", title: "Valor da Venda"},
		        { name: "descProduto", type: "text", width: 150, validate: "required", title: "Decrição do Produto"},
		        { name: "qtdEstoque", type: "text", width: 150, validate: "required", title: "Quantidade em Estoque"},
			    ]
		  })
	
}

$(document).ready(function () {
	
	  $.ajax({
	        type: "GET",
	        url: "getfornecimento"
	    }).done(function (value) {
	    	console.log(value);
	    });
	  
	  var DateField = function(config) {
		    jsGrid.Field.call(this, config);
		};

		DateField.prototype = new jsGrid.Field({
		    sorter: function(date1, date2) {
		        return new Date(date1) - new Date(date2);
		    },    
		    
		    itemTemplate: function(value) {
		        return value;
		    },
		    
		    filterTemplate: function() {
		        var now = new Date();
		        this._fromPicker = $("<input>").datepicker({ defaultDate: now.setFullYear(now.getFullYear() - 1) });
		        this._toPicker = $("<input>").datepicker({ defaultDate: now.setFullYear(now.getFullYear() + 1) });
		        return $("<div>").append(this._fromPicker).append(this._toPicker);
		    },
		    
		    insertTemplate: function(value) {
		        return this._insertPicker = $("<input>").datepicker({ format: 'mm/dd/yyyy'});
		    },
		    
		    editTemplate: function(value) {
		        return this._editPicker = $("<input>").datepicker().datepicker("setDate", new Date(value));
		    },
		    
		    insertValue: function() {
		        return this._insertPicker.datepicker("getDate").toISOString();
		    },
		    
		    editValue: function() {
		        return this._editPicker.datepicker("getDate").toISOString();
		    },
		    
		    filterValue: function() {
		        return {
		            from: this._fromPicker.datepicker("getDate"),
		            to: this._toPicker.datepicker("getDate")
		        };
		    }
		});

		jsGrid.fields.date = DateField;
	  

	  $("#jsGrid").jsGrid({
		    autoload: true,
		    inserting: false,
		    editing: true,
		    width: "100%",
		    height: 300,
		    paging: true,
		    pageSize: 8,
	        pageButtonCount: 5,
	        pagerFormat: "Página Atual: {pageIndex} &nbsp;&nbsp; {first} {prev} {pages} {next} {last} &nbsp;&nbsp; Página Atual: {pageCount} Total: {itemCount}",
            pagePrevText: "<",
            pageNextText: ">",
            pageFirstText: "<<",
            pageLastText: ">>",
		    controller: {
		        loadData: function(item) {
		            return $.ajax({
		                type: "GET",
		                url: "getfornecimento",
		                data: item
		            });
		        },
		        
		        updateItem: function (item) {
                    return $.ajax({
                        type: "POST",
                        url: "edit",
                        data: {"codFornecimento": item.codFornecimento, "dataFornecimento": item.dataFornecimento.substring(0, 10), 
                        	"qtdFornecimento": item.qtdFornecimento, 
                        	"valorFornecimento": item.valorFornecimento}
                    });
                },
		   
                deleteItem: function (item) {
                    return $.ajax({
                        type: "POST",
                        url: "remove",
                        data: item
                    });
                }
		    },
		    fields: [
		        { name: "codFornecimento", type: "number", width: 150, validate: "required", title: "Código Fornecedor", editing: false},
		        { name: "dataFornecimento", type: "date", width: 150, validate: "required", title: "Data Fornecimento"},
		        { name: "qtdFornecimento", type: "number", width: 150, validate: "required", title: "Quantidade Fornecimento"},
		        { name: "valorFornecimento", type: "number", width: 150, validate: "required", title: "Valor Fornecimento"},
		        { type: "control", headerTemplate: function() {
                    return $("<button id=\"buttonChange\">").attr("class", "jsgrid-button jsgrid-insert-button button-class")
                    .on("click", function () 
                    {
                        $('#insertDataModal').modal('toggle');
                    });
            }}
		    ]
		});
});
  
$(document).ready(function () 
{
	$( ".getdata" ).on("keyup change", function() 
	{
		if (($($('.getdata')[0]).val().length > 0) && ($($('.getdata')[1]).val().length > 0))
		{
			$.ajax({
		        type: "POST",
		        url: "totalreceber",
		        data: {
		        	  dataInicial : $($('.getdata')[0]).val(),
		        	  dataFinal : $($('.getdata')[1]).val()
		        }
		    }).done(function (value) {
		    	if (value !== "")
		    		$($('.getdata')[2]).val(value);
		    	else
		    		$($('.getdata')[2]).val("Nada a receber entre essas datas");
		    });
		}
	});
	
	$("#datavenda").jsGrid({
	    autoload: true,
	    inserting: false,
	    editing: false,
	    width: "100%",
	    controller: {
	    	   loadData: function (data) {
	               return $.ajax({
	                   type: "POST",
	                   url: "orderbydatavenda",
	                   data: data,
	                   success: function (data){
	                	   console.log(data);
	                   }
	           });
		    }
	    },
	    
	    fields: [
	        { name: "0", type: "text", width: 150, validate: "required", title: "Código Venda"},
	        { name: "1", type: "text", width: 150, validate: "required", title: "Data Venda"},
	        { name: "2", type: "text", width: 150, validate: "required", title: "Quantidade Consumido"},
	        { name: "3", type: "text", width: 150, validate: "required", title: "Data Pagamento"},
	        { name: "4", type: "text", width: 150, validate: "required", title: "Código Produto"},
	        { name: "5", type: "text", width: 150, validate: "required", title: "Código Pessoa"},
	    ]
	});
});











  
  


  
  
  
  
  
  
  
  