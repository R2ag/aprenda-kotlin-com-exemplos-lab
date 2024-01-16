enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome:String, val email:String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val descricao:String, val nive:Nivel)

data class Formacao(val nome: String,val nivel:Nivel, var conteudos: mutableListOf<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional){
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional){
        conteudos.remove(conteudo)
    }

    fun detalhar(){
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos) - ${conteudo.descricao} (por ${conteudo.autor})")
        }
        println("Inscritos:")
        for (inscrito in inscritos) {
            println(" - ${inscrito.nome} (${inscrito.email})")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Thiago", "pedro@gmail.com")
    val usuario2 = Usuario("Pedro", "thiago@gmail.com")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90, "Conceitos básicos de Kotlin", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 120, "Tópicos avançados de Kotlin", Nivel.DIFICIL)

    // Criando uma formação e adicionando conteúdos
    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO)
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)

    // Matriculando usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Exibindo detalhes da formação
    formacaoKotlin.detalhar()
}
